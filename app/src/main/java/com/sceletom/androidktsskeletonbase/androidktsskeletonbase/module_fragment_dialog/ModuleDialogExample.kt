package com.sceletom.androidktsskeletonbase.androidktsskeletonbase.module_fragment_dialog

import com.sceletom.androidktsskeletonbase.androidktsskeletonbase.scope.FragmentScope
import com.sceleton.presentation.dialog_fragment.DialogExample
import com.sceleton.presentation.dialog_fragment.DialogExamplePresenter
import com.sceleton.presentation.dialog_fragment.IDialogExample
import dagger.Binds
import dagger.Module

@Module
abstract class ModuleDialogExample {
    @FragmentScope
    @Binds
    abstract fun bindsDialogExampleView(view : DialogExample) : IDialogExample.View
    @FragmentScope
    @Binds
    abstract fun bindsDialogExamplePresenter(presenter: DialogExamplePresenter) : IDialogExample.Presenter
}