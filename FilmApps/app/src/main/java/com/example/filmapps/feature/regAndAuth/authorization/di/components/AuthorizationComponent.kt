package com.example.filmapps.di.components

import com.example.filmapps.feature.regAndAuth.authorization.di.module.AuthorizationModule
import com.example.filmapps.feature.regAndAuth.authorization.di.scope.AuthorizationScope
import com.example.filmapps.feature.regAndAuth.presentation.viewModel.ViewModelFactory
import dagger.Component


@Component(modules = [AuthorizationModule::class], dependencies = [AppComponent::class])
@AuthorizationScope
interface AuthorizationComponent {
    fun viewModelsFactory(): ViewModelFactory
}