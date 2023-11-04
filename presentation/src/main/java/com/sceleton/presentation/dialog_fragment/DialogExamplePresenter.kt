package com.sceleton.presentation.dialog_fragment

import javax.inject.Inject

class DialogExamplePresenter @Inject constructor(private val view : IDialogExample.View)
    : IDialogExample.Presenter {
    override fun init() {
        view.nextStep(1)
    }

    override fun startView() {

    }

    override fun stopView() {

    }

    override fun pauseView() {

    }

    override fun destroyView() {

    }
}