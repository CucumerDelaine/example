package com.example.filmapps.featureRegAndAuth.featureRegistrations.di.components

import com.example.core.di.AppApi
import com.example.core_db_api.di.CoreDbApi
import com.example.filmapps.app.presentation.viewModel.ViewModelFactory
import com.example.filmapps.featureRegAndAuth.featureRegistrations.di.module.RegistrationModule
import com.example.filmapps.featureRegAndAuth.featureRegistrations.di.scope.RegistrationScope
import dagger.Component

@Component(modules = [RegistrationModule::class], dependencies = [CoreDbApi::class, AppApi::class])
@RegistrationScope
interface RegistrationComponent {
    fun viewModelsFactory(): ViewModelFactory
}
