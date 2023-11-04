package com.sceleton.presentation.activity

import android.os.Bundle
import com.sceleton.presentation.R
import com.sceleton.presentation.base.BaseActivity
import com.sceleton.presentation.base.BasePresenter
import com.sceleton.presentation.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(), IMainView.View {
    @Inject
    lateinit var presenter: IMainView.Presenter

    override val layoutRes: Int = R.layout.activity_main

    override fun initOnCreate() {

    }

    override fun createActivity(savedInstanceState: Bundle?) {
        binding.event = presenter
    }

    override fun stopActivity() {

    }

    override fun startActivity() {

    }

    override fun pauseActivity() {

    }

    override fun resumeActivity() {

    }

    override fun destroyActivity() {

    }

    override fun getPresenter(): BasePresenter = presenter

    override fun setAppBarText(name: String) {

    }

    override fun hideAppBar(visible: Boolean) {

    }

    override fun onMessage(message: String) {

    }

    override fun isProgress(flag: Boolean) {

    }

    override fun hideBottomNavigation(flag: Boolean) {

    }
}