package com.cyrillrx.library.data.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class CommonInterceptor(versionName: String, private val provider: DataProvider) : Interceptor {

    private val userAgent = UserAgent.create(versionName)

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()

        val newUrl = request.url().toString()
            .replace(GameApi.PLACEHOLDER_HOST, provider.getHost())

        val newRequest = request.newBuilder()
            .addHeaders(userAgent)
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }

    private fun Request.Builder.addHeaders(userAgent: String): Request.Builder = apply {
        header(Header.USER_AGENT, userAgent)
        header(Header.CONTENT_TYPE, Header.Value.JSON_APPLICATION)
        header(Header.ACCEPT, Header.Value.JSON_APPLICATION)
    }

    interface DataProvider {
        fun getHost(): String
    }
}
