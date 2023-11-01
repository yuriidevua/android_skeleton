package com.sceleton.featurelocalstorage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sceleton.featurelocalstorage.entry.Entry
import io.reactivex.rxjava3.core.Single

@Dao
interface LocaleDaoEntry {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListEntry(list: List<Entry>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEntry(entry: Entry)

    @Query("select * from entry")
    fun queryEntryList(): Single<List<Entry>>

    @Query("SELECT * FROM entry WHERE keyId IS :key")
    fun queryEntry(key: String?): Single<Entry>

    @Query("DELETE FROM entry")
    fun delete()
}