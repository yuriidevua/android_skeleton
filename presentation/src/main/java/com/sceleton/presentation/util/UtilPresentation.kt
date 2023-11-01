package com.leshchenko.presentation.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.OpenableColumns
import com.sceleton.comm.ErrorType
import io.reactivex.rxjava3.core.Single

fun utilTypeIntentFile(intent: Intent?, path: String,context: Context): Single<String> =
     Single.just(if (intent != null) {
        val returnUri = intent.data
        @SuppressLint("Recycle")
        val returnCursor = returnUri?.let {
            context.contentResolver.query(it, null, null, null, null)
        }
        val nameIndex = returnCursor?.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        returnCursor?.moveToFirst()
        val fileName = nameIndex?.let { returnCursor.getString(it) }
        var index = fileName?.lastIndexOf(".")
        index?.let { fileName?.substring(++index) }.let { "" }
    } else {
        var index = path.lastIndexOf(".")
        path.substring(++index)
    })

fun utilUriFileIntent(intent : Intent) : Single<Uri>{
    val uri = if (intent.data != null) {
        intent.data
    } else {
        val item = intent.clipData?.getItemAt(0)
        item?.uri?.normalizeScheme()
    }
    return if (uri != null)Single.just(uri) else Single.error(Throwable(
        ErrorType.ERROR.type.plus(" "
        .plus("uri == null"))))
}
