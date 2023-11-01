package com.sceleton.presentation.router

import androidx.drawerlayout.widget.DrawerLayout
import com.sceleton.presentation.base.BaseDialogFragment
import io.reactivex.rxjava3.core.Single

interface IRouter {
    fun init(drawerLayout: DrawerLayout)

    fun onStartView()

    fun activeBackStack(flag: Boolean)

    fun onBackPressed()

    fun <T : BaseDialogFragment<*>> stepDialog(fragment: T): Single<Int>

    fun setAppBarText(name: String)

    fun hideAppBar(state: Boolean)

    fun hideBottomNavigation(flag: Boolean)

    fun onStopView()

    fun transaction(cmd: String, json: String)

    fun transaction(cmd: String)

    fun restartApp()

    fun isProgress(flag: Boolean)

    fun removeAllFrag()

    fun openDrawer()

    fun closeDrawer()

    fun popBackStack()

    fun navigationTransactional(number: Int)
}