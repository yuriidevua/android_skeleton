package com.sceleton.presentation.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatDialogFragment
import io.reactivex.rxjava3.core.SingleEmitter


abstract class BaseDialogFragment<Binding : ViewDataBinding> : DaggerAppCompatDialogFragment() {
    protected var binding: Binding? = null
        private set
    private var emitter: SingleEmitter<Int>? = null

    protected abstract fun getPresenter(): BasePresenter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        initDialogView()
        return binding!!.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        createDialog()
        return super.onCreateDialog(savedInstanceState)
    }

    protected abstract fun initDialogView()
    protected abstract fun createDialog()
    override fun onDestroy() {
        getPresenter().stopView()
        detachFragment()
        super.onDestroy()
    }

    override fun onStop() {
        getPresenter().stopView()
        super.onStop()
    }

    override fun onDetach() {
        getPresenter().destroyView()
        detachFragment()
        super.onDetach()
    }

    protected abstract fun detachFragment()

    @get:LayoutRes
    protected abstract val layoutRes: Int
    fun onMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    fun nextStep(key: Int) {
        if (emitter != null) {
            emitter!!.onSuccess(key)
        }
    }

    fun errorStep(exception: Throwable) {
        if (emitter != null) {
            emitter!!.onError(exception)
        }
    }


    fun setEmitter(emitter: SingleEmitter<Int>?) {
        this.emitter = emitter
    }
}