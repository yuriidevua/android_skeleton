package com.sceletom.androidktsskeletonbase.androidktsskeletonbase


import com.sceletom.androidktsskeletonbase.androidktsskeletonbase.module_fragment_dialog.ModuleDialogExample
import com.sceletom.androidktsskeletonbase.androidktsskeletonbase.scope.FragmentScope
import com.sceleton.presentation.dialog_fragment.DialogExample
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModuleFragment {
    @FragmentScope
    @ContributesAndroidInjector(modules = [ModuleDialogExample::class])
    abstract fun bindDialogFragmentExample() : DialogExample
}