package com.sceletom.androidktsskeletonbase.androidktsskeletonbase.module_activity


import com.sceletom.androidktsskeletonbase.androidktsskeletonbase.scope.ActivityScope
import com.sceleton.domain.main.MainUseCase
import com.sceleton.portdomain.main.IMainUseCase
import com.sceleton.presentation.activity.IMainView
import com.sceleton.presentation.activity.MainActivity
import com.sceleton.presentation.activity.MainPresenter
import com.sceleton.presentation.router.IRouter
import com.sceleton.presentation.router.Router
import com.tbruyelle.rxpermissions3.RxPermissions
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ModuleMainActivity {
    @ActivityScope
    @Binds
    abstract fun bindsMainView(view : MainActivity) : IMainView.View
    @ActivityScope
    @Binds
    abstract fun bindsMainPresenter(presenter : MainPresenter) : IMainView.Presenter
    companion object{
        @ActivityScope
        @Provides
        fun providesRouter(activity: MainActivity) :
                IRouter = Router(view = activity,activity = activity)
        @ActivityScope
        @Provides
        fun providePermissions(activity: MainActivity): RxPermissions = RxPermissions(activity)
    }
    @ActivityScope
    @Binds
    abstract fun bindMainUseCase(useCase: MainUseCase) : IMainUseCase
}