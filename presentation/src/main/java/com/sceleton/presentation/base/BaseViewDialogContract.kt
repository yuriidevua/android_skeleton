package com.sceleton.presentation.base

interface BaseViewDialogContract {
    fun onMessage(message: String)
    fun nextStep(key: Int);
    fun errorStep(exception: Throwable)
}