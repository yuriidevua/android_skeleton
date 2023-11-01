package com.sceletom.androidktsskeletonbase.androidktsskeletonbase

import com.sceletom.androidktsskeletonbase.androidktsskeletonbase.module_activity.ModuleMainActivity
import com.sceletom.androidktsskeletonbase.androidktsskeletonbase.scope.ActivityScope
import com.sceleton.presentation.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModuleActivity {
    @ActivityScope
    @ContributesAndroidInjector(modules = [ModuleMainActivity::class, BuildersModuleFragment::class])
    abstract fun bindMapActivity(): MainActivity
}