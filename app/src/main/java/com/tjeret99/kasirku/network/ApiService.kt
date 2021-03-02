package com.tjeret99.kasirku.network

import com.tjeret99.kasirku.entities.AccessToken
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {


    @POST("register")
    @FormUrlEncoded
    open fun register(@Field("name") name: String?, @Field("email") email: String?, @Field("password") password: String?): Call<AccessToken?>?

    @POST("login")
    @FormUrlEncoded
    fun login(@Field("username") username: String?, @Field("password") password: String?): Call<AccessToken>

    @POST("refresh")
    @FormUrlEncoded
    fun refresh(@Field("refresh_token") refreshToken: String?): Call<AccessToken?>?

//    @GET("posts")
//    fun posts(): Call<PostResponse?>?
}