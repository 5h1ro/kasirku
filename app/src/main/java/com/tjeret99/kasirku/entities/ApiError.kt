package com.tjeret99.kasirku.entities

import com.squareup.moshi.Json;

import java.util.List
import java.util.Map

class ApiError {

    private var message: String? = null
    private var errors: Map<String?, List<String?>?>? = null

    fun getMessage(): String? {
        return message
    }

    fun getErrors(): Map<String?, List<String?>?>? {
        return errors
    }
}