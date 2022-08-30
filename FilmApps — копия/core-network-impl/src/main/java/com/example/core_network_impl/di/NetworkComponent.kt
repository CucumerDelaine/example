package com.example.core_network_impl.di

import com.example.core_network_api.di.CoreNetworkApi
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, NetworkModuleBinds::class])
@Singleton
interface NetworkComponent: CoreNetworkApi