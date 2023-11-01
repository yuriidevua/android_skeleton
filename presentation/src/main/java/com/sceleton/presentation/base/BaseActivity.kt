package com.sceleton.presentation.base
import android.util.Pair
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.sceleton.presentation.BuildConfig
import dagger.android.support.DaggerAppCompatActivity
import java.io.File
import java.util.Objects


abstract class BaseActivity<Binding : ViewDataBinding> : DaggerAppCompatActivity() {
    protected lateinit var binding: Binding
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!BuildConfig.DEBUG) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE
            )
        }
        initOnCreate()
        binding = DataBindingUtil.setContentView(this, layoutRes)
        createActivity(savedInstanceState)
    }

    @get:LayoutRes
    protected abstract val layoutRes: Int

    protected abstract fun initOnCreate()
    protected abstract fun createActivity(savedInstanceState: Bundle?)
    protected abstract fun stopActivity()
    protected abstract fun startActivity()
    protected abstract fun pauseActivity()
    protected abstract fun resumeActivity()
    protected abstract fun destroyActivity()
    protected abstract fun getPresenter(): BasePresenter

    override fun onDestroy() {
        getPresenter().destroyView()
        destroyActivity()
        if (::binding.isInitialized) binding.unbind()
        super.onDestroy()
    }


    override fun onBackPressed() {
        val manager = supportFragmentManager
        if (manager.backStackEntryCount == 1) {
            finish()
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
        super.onBackPressed()
    }


    protected fun toastShort(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    protected fun toastLong(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


    override fun onStart() {
        super.onStart()
        getPresenter().startView()
        startActivity()
    }


    override fun onStop() {
        getPresenter().stopView()
        stopActivity()
        super.onStop()
    }

    override fun onPause() {
        getPresenter().pauseView()
        pauseActivity()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        resumeActivity()
    }

    fun hideKeyboard() {
        val imm = this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        Objects.requireNonNull(imm).hideSoftInputFromWindow(this.window.decorView.windowToken, 0)
    }

    fun showKeyboard() {
        val imm = this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        Objects.requireNonNull(imm)
            .showSoftInput(this.window.decorView, InputMethodManager.SHOW_IMPLICIT)
    }

    protected fun share(path: String) {
        val f = File(path)
        val intentShareFile = Intent(Intent.ACTION_SEND)
        if (f.exists()) {
            val imageUri = FileProvider.getUriForFile(
                this,
                this.applicationContext.packageName + ".provider",
                f
            )
            intentShareFile.type = "file/*"
            intentShareFile.putExtra(Intent.EXTRA_STREAM, imageUri)
            intentShareFile.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            val chooser = Intent.createChooser(intentShareFile, "Share File")
            @SuppressLint("QueryPermissionsNeeded") val resInfoList =
                this.packageManager.queryIntentActivities(
                    chooser,
                    PackageManager.MATCH_DEFAULT_ONLY
                )
            for (resolveInfo in resInfoList) {
                val packageName = resolveInfo.activityInfo.packageName
                grantUriPermission(
                    packageName, imageUri,
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
            }
            startActivity(chooser)
        }
    }
    protected fun openIntent(path: Pair<String,String>){
        val file = File(path.second)
        val intent = Intent(Intent.ACTION_VIEW)
            .setDataAndType(
                FileProvider.getUriForFile(this, "$packageName.provider", file),
                if ("mp4" == path.first || "m4v" == path.first) "video/*" else "image/*"
            ).addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(Intent.createChooser(intent, "Share Via"))
    }
}