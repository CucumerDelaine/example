package com.example.filmapps.feature.regAndAuth.authorization.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.feature.regAndAuth.authorization.di.scope.AuthorizationScope
import com.example.filmapps.feature.regAndAuth.authorization.domain.useCase.GetInfoAboutRegisterUseCase
import com.example.filmapps.feature.regAndAuth.authorization.domain.useCase.GetInfoAboutRegisterUseCaseImpl
import com.example.filmapps.feature.regAndAuth.authorization.presentation.viewModel.AuthorizationViewModel
import com.example.filmapps.feature.regAndAuth.data.repositories.UserRepositories
import com.example.filmapps.feature.regAndAuth.data.repositories.UserRepositoriesImpl
import com.example.filmapps.feature.regAndAuth.di.module.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface AuthorizationModule {

    @Binds
    @AuthorizationScope
    fun provideUserRepositories(userRepositories: UserRepositoriesImpl) : UserRepositories

    @Binds
    @AuthorizationScope
    fun provideGetUserDataUseCase(getInfoAboutRegisterUseCase: GetInfoAboutRegisterUseCaseImpl) : GetInfoAboutRegisterUseCase

    @Binds
    @IntoMap
    @ViewModelKey(AuthorizationViewModel::class)
    fun bindViewModel(authorizationViewModel: AuthorizationViewModel): ViewModel
}