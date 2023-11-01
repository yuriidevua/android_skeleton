package com.sceleton.portdata

import android.net.Uri
import io.reactivex.rxjava3.core.Single

interface IRepositoryUtil {
    fun inputStreamUtil(uri: Uri): Single<ByteArray>

    fun prefSaveString(key : String, value : String)

    fun prefLoadString(key : String) : String

    fun prefSaveLong(key : String, value : Long)

    fun prefLoadLong(key : String) : Long
}