package com.sceleton.presentation.base

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Point
import android.os.Bundle
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.window.layout.WindowMetrics
import androidx.window.layout.WindowMetricsCalculator
import dagger.android.support.DaggerFragment
import java.io.File
import java.util.Objects
import kotlin.math.min

abstract class BaseFragment<Binding : ViewDataBinding> : DaggerFragment() {
    protected abstract fun getPresenter(): BasePresenter
    protected lateinit var binding: Binding
        private set

    override fun onAttach(context: Context) {
        super.onAttach(context)
        attachFragment()
    }

    override fun onStop() {
        getPresenter().stopView()
        stopFragment()
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
        getPresenter().startView()
        startFragment()
    }

    override fun onPause() {
        getPresenter().pauseView()
        pauseFragment()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        resume()
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        initFragmentView()
        return binding.root
    }

    protected fun toastShort(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    protected fun toastLong(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    @get:LayoutRes
    protected abstract val layoutRes: Int
    protected abstract fun initFragmentView()
    protected abstract fun attachFragment()
    protected abstract fun startFragment()
    protected abstract fun stopFragment()
    protected abstract fun destroyFragment()
    protected abstract fun pauseFragment()
    protected abstract fun resume()
    override fun onDestroy() {
        getPresenter().destroyView()
        if (::binding.isInitialized) binding.unbind()
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDetach() {
        super.onDetach()
    }

    fun shareFile(path : String){
        val f = File(path)
        val intentShareFile = Intent(Intent.ACTION_SEND)
        if (f.exists()) {
            val imageUri = FileProvider.getUriForFile(
                requireActivity(),
                requireActivity().packageName + ".provider",
                f
            )
            intentShareFile.type = "file/*"
            intentShareFile.putExtra(Intent.EXTRA_STREAM, imageUri)
            intentShareFile.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            val chooser = Intent.createChooser(intentShareFile, "Share File")
            //
            @SuppressLint("QueryPermissionsNeeded") val resInfoList =
                requireActivity().packageManager.queryIntentActivities(
                    chooser,
                    PackageManager.MATCH_DEFAULT_ONLY
                )
            for (resolveInfo in resInfoList) {
                val packageName = resolveInfo.activityInfo.packageName
                requireActivity().grantUriPermission(
                    packageName,
                    imageUri,
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
            }
            super.startActivity(chooser)
        }
    }

    fun openIntent(pair : Pair<String,String>){
        val file = File(pair.second)
        val intent = Intent(Intent.ACTION_VIEW)
            .setDataAndType(
                FileProvider.getUriForFile(
                    requireActivity(), requireActivity()
                        .packageName + ".provider", file
                ),
                if ("mp4" == pair.first || "m4v" == pair.first) "video/*" else "image/*"
            ).addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(Intent.createChooser(intent, "Share Via"))
    }

     fun getDimension(activity : Activity): Int {
         val windowMetrics: WindowMetrics =
             WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(activity)
         val height: Int = windowMetrics.bounds.height()
         val width: Int = windowMetrics.bounds.width()
        return min(height,width)
    }

    fun hideKeyboard() {
        val imm =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        Objects.requireNonNull(imm)
            .hideSoftInputFromWindow(requireActivity().window.decorView.windowToken, 0)
    }

    fun showKeyboard() {
        val imm =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        Objects.requireNonNull(imm)
            .showSoftInput(requireActivity().window.decorView, InputMethodManager.SHOW_IMPLICIT)
    }

    protected open fun getDimension(): Int {
        val point = Point()
        requireActivity().windowManager.defaultDisplay.getSize(point)
        return min(point.x, point.y)
    }
}