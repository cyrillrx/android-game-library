package com.cyrillrx.library.data.api

import com.cyrillrx.library.BuildConfig
import com.cyrillrx.library.Config
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object GameApi {
    const val PLACEHOLDER_HOST = "_host_"
    val apiV1: GameService = createService()

    private const val READ_TIMEOUT_SEC: Long = 20L

    private fun createService(): GameService = Retrofit.Builder()
        .baseUrl("http://$PLACEHOLDER_HOST/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(createOkHttpClient())
        .build()
        .create(GameService::class.java)

    private fun createOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT_SEC, TimeUnit.SECONDS)
            .addInterceptor(createCommonInterceptor())
            .build()

    private fun createCommonInterceptor() = CommonInterceptor(
        BuildConfig.VERSION_NAME,
        object : CommonInterceptor.DataProvider {
            override fun getHost(): String = Config.host.value
        }
    )
}
