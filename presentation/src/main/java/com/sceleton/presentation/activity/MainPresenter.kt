package com.sceleton.presentation.activity

import com.sceleton.portdomain.main.IMainUseCase
import com.sceleton.presentation.router.ConstRouter
import com.sceleton.presentation.router.IRouter
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter @Inject constructor(private val view : IMainView.View,
                                        private val useCase : IMainUseCase,
                                        private val router : IRouter
) : IMainView.Presenter {
    private val disposable  = CompositeDisposable()
    override fun startExampleDialog() {
        disposable.add(router.dialogTransaction(ConstRouter.DIALOG_EXAMPLE.route)
            .subscribe({
                //TODO result dialog
            },{
                //TODO error dialog
            }))
    }

    override fun startView() {

    }

    override fun stopView() {
        disposable.clear()
    }

    override fun pauseView() {

    }

    override fun destroyView() {
        disposable.dispose()
    }
}