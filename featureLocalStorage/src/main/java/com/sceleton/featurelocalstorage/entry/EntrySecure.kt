package com.sceleton.featurelocalstorage.entry

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sceleton.featurelocalstorage.BuildConfig


@Entity(tableName = "entry_secure")
class EntrySecure(@field:PrimaryKey var keyId: String, var value: String) {

    override fun toString(): String {
        return if (BuildConfig.DEBUG) "EntrySecure{" +
                "keyId='" + keyId + '\'' +
                ", value='" + value + '\'' +
                '}' else ""
    }
}