package com.tjeret99.kasirku


import com.tjeret99.kasirku.entities.ApiError
import com.tjeret99.kasirku.network.RetrofitBuilder
import okhttp3.ResponseBody
import retrofit2.Converter
import java.io.IOException


class Utils {

    fun converErrors(response: ResponseBody?): ApiError? {

        val retrofitBuilder = RetrofitBuilder()

        val converter: Converter<ResponseBody, ApiError> = retrofitBuilder.getRetrofit().responseBodyConverter<ApiError>(ApiError::class.java, arrayOfNulls<Annotation>(0))
        var apiError: ApiError? = null
        try {
            apiError = converter.convert(response)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return apiError
    }
}