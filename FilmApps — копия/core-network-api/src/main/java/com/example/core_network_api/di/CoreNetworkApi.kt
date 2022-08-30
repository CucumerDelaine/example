package com.example.core_network_api.di

import com.example.core_network_api.data.NetworkRepository

interface CoreNetworkApi {
    fun getNetworkRepository(): NetworkRepository
}