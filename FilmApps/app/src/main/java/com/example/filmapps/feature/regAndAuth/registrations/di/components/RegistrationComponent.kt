package com.example.filmapps.di.components

import com.example.filmapps.feature.regAndAuth.presentation.viewModel.ViewModelFactory
import com.example.filmapps.feature.regAndAuth.registrations.di.module.RegistrationModule
import com.example.filmapps.feature.regAndAuth.registrations.di.scope.RegistrationScope
import dagger.Component

@Component(modules = [RegistrationModule::class], dependencies = [AppComponent::class])
@RegistrationScope
interface RegistrationComponent {
    fun viewModelsFactory(): ViewModelFactory
}
