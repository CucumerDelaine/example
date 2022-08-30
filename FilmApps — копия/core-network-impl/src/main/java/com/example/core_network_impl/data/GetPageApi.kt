package com.example.core_network_impl.data

import retrofit2.http.GET
import retrofit2.http.Query

interface GetPageApi {

    @GET("character/")
    fun getPage(@Query("page") page: Int): DataApi
}