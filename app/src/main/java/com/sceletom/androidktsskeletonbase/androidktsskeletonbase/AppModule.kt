package com.sceletom.androidktsskeletonbase.androidktsskeletonbase

import android.content.Context
import com.sceleton.comm.SharedPreferencesStorage
import com.sceleton.data.RepositoryDAO
import com.sceleton.data.RepositoryUtil
import com.sceleton.featurelocalstorage.LocaleStorage
import com.sceleton.portdata.IRepositoryDAO
import com.sceleton.portdata.IRepositoryUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {
    companion object {
        @Singleton
        @Provides
        fun provideContext(app: App): Context = app.applicationContext

        @Singleton
        @Provides
        fun provideSharedPreferences(context: Context): SharedPreferencesStorage =
            SharedPreferencesStorage(context)

        @Singleton
        @Provides
        fun provideUtilRepository(context: Context,sharedPref: SharedPreferencesStorage
        ): IRepositoryUtil = RepositoryUtil(context,sharedPref)

        @Singleton
        @Provides
        fun provideRepositoryDAO(context: Context) : IRepositoryDAO = RepositoryDAO(LocaleStorage(context))

    }
}