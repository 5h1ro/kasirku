package com.tjeret99.kasirku.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.tjeret99.kasirku.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException


class RetrofitBuilder {

    private val BASE_URL = "http://192.168.0.10/tutos/tuto_passport/public/api/"

    private val client: OkHttpClient = buildClient()
    private val retrofit: Retrofit = buildRetrofit(client)

    private fun buildClient(): OkHttpClient {


        val builder = OkHttpClient.Builder()
                .addInterceptor(object : Interceptor {
                    @Throws(IOException::class)
                    override fun intercept(chain: Interceptor.Chain): Response? {

                        var request: Request = chain.request()
                        val builder: Request.Builder = request.newBuilder()
                                .addHeader("Accept", "application/json")
                                .addHeader("Connection", "close")

                        request = builder.build()
                        return chain.proceed(request)
                    }
                })
        if (BuildConfig.DEBUG) {
            builder.addNetworkInterceptor(StethoInterceptor())
        }
        return builder.build()
    }


    private fun buildRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

    fun <T> createService(service: Class<T>?): T {
        return retrofit.create(service)
    }

    fun getRetrofit(): Retrofit {
        return retrofit
    }

}