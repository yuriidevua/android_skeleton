package com.sceleton.data

import android.content.Context
import android.net.Uri
import com.sceleton.comm.SharedPreferencesStorage
import com.sceleton.portdata.IRepositoryUtil
import io.reactivex.rxjava3.core.Single
import timber.log.Timber
import java.io.BufferedInputStream
import javax.inject.Inject

class RepositoryUtil @Inject constructor(private val context: Context,
                                         private val pref: SharedPreferencesStorage
)
    : IRepositoryUtil {
     override  fun inputStreamUtil(uri: Uri): Single<ByteArray> {
        return Single.create {
            Timber.tag(RepositoryUtil::class.java.simpleName)
                .e("inputStreamUtil Thread %s", Thread.currentThread())
            val bufferedInputStream = BufferedInputStream(
                uri.let { itUri: Uri ->
                    context.contentResolver
                        .openInputStream(itUri)
                }
            )
            val file: ByteArray = bufferedInputStream.readBytes()
            bufferedInputStream.close()
            it.onSuccess(file)
        }
    }

    override fun prefSaveString(key: String, value: String) = pref.saveDataString(key,value)

    override fun prefLoadString(key: String): String = pref.loadDataString(key)
    override fun prefSaveLong(key: String, value: Long) = pref.saveDataLong(key,value)

    override fun prefLoadLong(key: String): Long =  pref.loadDataLong(key)


}