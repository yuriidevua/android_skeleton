package com.sceleton.featurelocalstorage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sceleton.featurelocalstorage.entry.Entry
import com.sceleton.featurelocalstorage.entry.EntrySecure

@Database(entities = [Entry::class, EntrySecure::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract fun daoSecure(): LocaleDAOSecure
    abstract fun daoEntry(): LocaleDaoEntry
}