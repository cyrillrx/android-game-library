package com.cyrillrx.library.data.api

import android.os.Build

object UserAgent {
    fun create(versionName: String): String {
        val osVersion = "${Build.VERSION.SDK_INT} ${Build.VERSION.RELEASE}"
        return "GameLib/android/$versionName (Android; $osVersion)"
    }
}
