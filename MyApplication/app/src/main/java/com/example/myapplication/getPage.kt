package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface GetPage {

    @GET("character")
    fun getPage(): Call<DataApi>
}