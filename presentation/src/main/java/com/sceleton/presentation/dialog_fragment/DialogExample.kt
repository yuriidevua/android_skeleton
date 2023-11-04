package com.sceleton.presentation.dialog_fragment


import com.sceleton.presentation.R
import com.sceleton.presentation.base.BaseDialogFragment
import com.sceleton.presentation.base.BasePresenter
import com.sceleton.presentation.databinding.FragmentDialogExampleBinding
import javax.inject.Inject

class DialogExample : BaseDialogFragment<FragmentDialogExampleBinding>(), IDialogExample.View{
    override val layoutRes: Int = R.layout.fragment_dialog_example
    @Inject
    lateinit var presenter:IDialogExample.Presenter
    companion object {
        @JvmStatic
        fun newInstance() = DialogExample()
    }

    override fun getPresenter(): BasePresenter = presenter

    override fun initDialogView() {
        presenter.init()
    }

    override fun createDialog() {

    }

    override fun detachFragment() {

    }
}