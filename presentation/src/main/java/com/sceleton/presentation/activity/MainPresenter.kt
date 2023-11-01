package com.sceleton.presentation.activity

import com.sceleton.portdomain.main.IMainUseCase
import com.sceleton.presentation.router.IRouter
import javax.inject.Inject

class MainPresenter @Inject constructor(private val view : IMainView.View,
                                        private val useCase : IMainUseCase,
                                        private val router : IRouter
)
    : IMainView.Presenter {
    override fun startView() {

    }

    override fun stopView() {

    }

    override fun pauseView() {

    }

    override fun destroyView() {

    }
}