package com.example.filmapps.featureRegAndAuth.featureAuthorization.di.component

import com.example.core.di.AppApi
import com.example.core_db_api.di.CoreDbApi
import com.example.filmapps.app.presentation.viewModel.ViewModelFactory
import com.example.filmapps.featureRegAndAuth.featureAuthorization.di.module.AuthorizationModule
import com.example.filmapps.featureRegAndAuth.featureAuthorization.di.scope.AuthorizationScope
import dagger.Component


@Component(modules = [AuthorizationModule::class], dependencies = [CoreDbApi::class, AppApi::class])
@AuthorizationScope
interface AuthorizationComponent {
    fun viewModelsFactory(): ViewModelFactory
}