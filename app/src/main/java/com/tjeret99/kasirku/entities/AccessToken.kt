package com.tjeret99.kasirku.entities

import com.squareup.moshi.Json

class AccessToken {

    @Json(name = "token_type")
    var tokenType: String? = null

    @Json(name = "expires_in")
    var expiresIn = 0

    @Json(name = "access_token")
    var accessToken: String? = null

    @Json(name = "refresh_token")
    var refreshToken: String? = null

    fun getTokentype(): String? {
        return tokenType
    }

    fun getExpiresin(): Int {
        return expiresIn
    }

    fun getAccesstoken(): String? {
        return accessToken
    }

    fun getRefreshtoken(): String? {
        return refreshToken
    }

    fun setTokentype(tokenType: String?) {
        this.tokenType = tokenType
    }

    fun setExpiresin(expiresIn: Int) {
        this.expiresIn = expiresIn
    }

    fun setAccesstoken(accessToken: String?) {
        this.accessToken = accessToken
    }

    fun setRefreshtoken(refreshToken: String?) {
        this.refreshToken = refreshToken
    }
}