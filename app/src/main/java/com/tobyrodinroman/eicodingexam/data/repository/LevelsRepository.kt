package com.tobyrodinroman.eicodingexam.data.repository

import android.content.Context
import com.google.gson.Gson
import com.tobyrodinroman.eicodingexam.data.model.GetLevelsResponse
import javax.inject.Inject

class LevelsRepository @Inject constructor(private val context: Context) {

    fun getLevels(): GetLevelsResponse {
        val jsonString =
            context.assets.open("api_response.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        return gson.fromJson(jsonString, GetLevelsResponse::class.java)
    }
}
