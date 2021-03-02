package com.tjeret99.kasirku

import android.content.SharedPreferences
import com.tjeret99.kasirku.entities.AccessToken

class TokenManager {

    private var prefs: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    private var INSTANCE: TokenManager? = null

    private fun TokenManager(prefs: SharedPreferences) {
        this.prefs = prefs
        this.editor = prefs.edit()
    }

    @Synchronized
    fun getInstance(prefs: SharedPreferences?): TokenManager? {
        if (INSTANCE == null) {
//            INSTANCE = TokenManager(prefs!!)
            INSTANCE = TokenManager()
        }
        return INSTANCE
    }

    fun saveToken(token: AccessToken) {
        val token = AccessToken()
        editor!!.putString("ACCESS_TOKEN", token.getAccesstoken()).commit()
        editor!!.putString("REFRESH_TOKEN", token.getRefreshtoken()).commit()
    }

    fun deleteToken() {
        editor!!.remove("ACCESS_TOKEN").commit()
        editor!!.remove("REFRESH_TOKEN").commit()
    }

    fun getToken(): AccessToken? {
        val token = AccessToken()
        token.setAccesstoken(prefs!!.getString("ACCESS_TOKEN", null))
        token.setRefreshtoken(prefs!!.getString("REFRESH_TOKEN", null))
        return token
    }
}