package com.sceleton.featurelocalstorage

import android.content.Context
import androidx.room.Room

class LocaleStorage(context: Context) : Dao {
    private val dao: DataBase

    init {
        dao = Room.databaseBuilder(context.applicationContext,
            DataBase::class.java,
            BuildConfig.DAO_NAME)
            .build()
    }

    override fun daoSecure(): LocaleDAOSecure {
        return dao.daoSecure()
    }

    override fun daoEntry(): LocaleDaoEntry {
        return dao.daoEntry()
    }
}