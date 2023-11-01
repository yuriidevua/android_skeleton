package com.sceleton.featurelocalstorage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sceleton.featurelocalstorage.entry.EntrySecure
import io.reactivex.rxjava3.core.Single

@Dao
interface LocaleDAOSecure {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListEntry(list: List<EntrySecure>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEntry(entry: EntrySecure): Long

    @Query("select * from entry_secure")
    fun queryEntryList(): Single<List<EntrySecure>>

    @Query("SELECT * FROM entry_secure WHERE keyId IS :key")
    fun queryEntry(key: String?): Single<EntrySecure>

    @Query("DELETE FROM entry_secure")
    fun delete()
}