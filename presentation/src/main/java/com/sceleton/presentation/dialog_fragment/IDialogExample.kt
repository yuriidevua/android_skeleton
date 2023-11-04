package com.sceleton.presentation.dialog_fragment

import com.sceleton.presentation.base.BasePresenter
import com.sceleton.presentation.base.BaseViewDialogContract

interface IDialogExample {

    interface View : BaseViewDialogContract {


    }

    interface Presenter : BasePresenter{
        fun init()
    }
}