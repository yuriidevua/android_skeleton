package com.sceleton.domain

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.CompletableTransformer
import io.reactivex.rxjava3.core.FlowableTransformer
import io.reactivex.rxjava3.core.ObservableTransformer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.SingleTransformer
import io.reactivex.rxjava3.schedulers.Schedulers


abstract class BaseInteractor {
    private var jobThread: Scheduler = Schedulers.io()
    private var observeThread: Scheduler = AndroidSchedulers.mainThread()

    protected open fun <T : Any> applySingleSchedulers(): SingleTransformer<T, T> =
        SingleTransformer {
            it.subscribeOn(jobThread)
                .observeOn(observeThread)
        }

    protected open fun <T : Any> applyFlowableSchedulers(): FlowableTransformer<T, T> =
        FlowableTransformer {
            it.subscribeOn(jobThread)
                .observeOn(observeThread)
        }

    protected open fun <T : Any> applyObservableSchedulers(): ObservableTransformer<T, T> =
        ObservableTransformer {
            it.subscribeOn(jobThread)
                .observeOn(observeThread)
        }

    protected open fun applyCompletableSchedulers(): CompletableTransformer =
        CompletableTransformer {
            it.subscribeOn(jobThread)
                .observeOn(observeThread)
        }

}