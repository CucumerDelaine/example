package com.example.core.di

import android.content.Context

object CoreComponentManager {

    lateinit var coreComponent: AppApi

    fun init(context: Context) {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(context))
            .build()
    }
}