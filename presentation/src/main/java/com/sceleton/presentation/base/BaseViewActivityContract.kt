package com.sceleton.presentation.base

interface BaseViewActivityContract {
    fun setAppBarText(name: String)
    fun hideAppBar(visible: Boolean)
    fun onMessage(message: String)
    fun isProgress(flag: Boolean)

    fun hideBottomNavigation(flag: Boolean)

}