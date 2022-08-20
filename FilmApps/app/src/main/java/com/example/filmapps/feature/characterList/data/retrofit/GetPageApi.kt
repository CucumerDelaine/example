package com.example.filmapps.feature.characterList.data.retrofit

import com.example.filmapps.feature.characterList.data.model.DataApi
import retrofit2.http.GET
import retrofit2.http.Query

interface GetPageApi {

    @GET("character/")
    suspend fun getPage(@Query("page") page: Int): DataApi
}