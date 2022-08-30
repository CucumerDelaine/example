package com.example.core_db_impl.di

import android.content.Context
import com.example.core.di.AppApi
import com.example.core.di.CoreComponentManager
import com.example.core_db_api.di.CoreDbApi


object CoreDbComponentManager {
    private var coreDbComponent: CoreDbApi? = null

    fun getCoreDbComponent(): CoreDbApi {
        return coreDbComponent ?: DaggerCoreDbComponent
            .builder()
            .appApi(CoreComponentManager.coreComponent)
            .build()
            .also { coreDbComponent = it }
    }
}