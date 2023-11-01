package com.sceleton.presentation.router

import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.sceleton.presentation.base.BaseDialogFragment
import com.sceleton.presentation.base.BaseViewActivityContract
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.R
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class Router @Inject constructor(private val view : BaseViewActivityContract,
                                 activity : DaggerAppCompatActivity)
    : BaseRouter(activity), IRouter {
    private lateinit var  mDrawerLayout :DrawerLayout
    override fun init(drawerLayout: DrawerLayout) {
        mDrawerLayout = drawerLayout
    }

    override fun onStartView() {

    }

    override fun activeBackStack(flag: Boolean) {

    }

    override fun onBackPressed() = super.backPressedRouter()

    override fun <T : BaseDialogFragment<*>> stepDialog(fragment: T): Single<Int> = Single.defer {
            super.transactionFragmentDialog(fragment, R.id.content)
            Single.create(fragment::setEmitter)
    }

    override fun setAppBarText(name: String) = view.setAppBarText(name)

    override fun hideAppBar(state: Boolean) = view.hideAppBar(state)

    override fun hideBottomNavigation(flag: Boolean)  = view.hideBottomNavigation(flag)

    override fun onStopView() {

    }

    override fun transaction(cmd: String, json: String) {
        when (cmd) {
           //TODO transaction activity and fragments
        }
    }

    override fun transaction(cmd: String) {
        transaction(cmd,"")
    }


    override fun restartApp() = super.restartAppBase()

    override fun isProgress(flag: Boolean) = view.isProgress(flag)


    override fun removeAllFrag() {
        super.removeAllFragment()
    }


    override fun openDrawer() = mDrawerLayout.openDrawer(GravityCompat.START)

    override fun closeDrawer() = mDrawerLayout.closeDrawers().also {

    }
    override fun popBackStack() {
        super.popBackStackRouter()
    }

    override fun navigationTransactional(number: Int) {
        closeDrawer()
        when (number) {
           //TODO navigation transaction fragment
        }
    }
}