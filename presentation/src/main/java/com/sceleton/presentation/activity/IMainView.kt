package com.sceleton.presentation.activity

import com.sceleton.presentation.base.BasePresenter
import com.sceleton.presentation.base.BaseViewActivityContract

interface IMainView {
    interface View : BaseViewActivityContract {

    }

    interface Presenter : BasePresenter {
        fun startExampleDialog()
    }
}