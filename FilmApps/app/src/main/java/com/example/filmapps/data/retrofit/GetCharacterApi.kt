package com.example.filmapps.data.retrofit

import com.example.filmapps.data.model.ResultCharacterApi
import retrofit2.http.GET
import retrofit2.http.Path

interface GetCharacterApi {
    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: String): ResultCharacterApi
}