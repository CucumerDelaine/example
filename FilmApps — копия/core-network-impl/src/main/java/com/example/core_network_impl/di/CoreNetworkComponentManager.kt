package com.example.core_network_impl.di

import com.example.core_network_api.di.CoreNetworkApi

object CoreNetworkComponentManager {
    private var networkComponent: CoreNetworkApi? = null

    fun getNetworkComponent(): CoreNetworkApi {
        return networkComponent ?: DaggerNetworkComponent
            .builder()
            .build()
            .also { networkComponent = it }
    }
}