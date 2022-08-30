package com.example.filmapps.featureRegAndAuth.featureAuthorization.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.app.di.module.ViewModelKey
import com.example.filmapps.featureAuthRegApi.data.repository.UserRepositories
import com.example.filmapps.featureAuthRegApi.featureAuthorizationApi.domain.useCase.GetInfoAboutRegisterUseCase
import com.example.filmapps.featureRegAndAuth.data.repositories.UserRepositoriesImpl
import com.example.filmapps.featureRegAndAuth.featureAuthorization.di.scope.AuthorizationScope
import com.example.filmapps.featureRegAndAuth.featureAuthorization.domain.useCase.GetInfoAboutRegisterUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface AuthorizationModule {

    @Binds
    @AuthorizationScope
    fun provideUserRepositories(authRepositories: UserRepositoriesImpl) : UserRepositories

    @Binds
    @AuthorizationScope
    fun provideGetUserDataUseCase(getInfoAboutRegisterUseCase: GetInfoAboutRegisterUseCaseImpl) : GetInfoAboutRegisterUseCase

    @Binds
    @IntoMap
    @ViewModelKey(com.example.filmapps.featureRegAndAuth.featureAuthorization.presentation.viewModel.AuthorizationViewModel::class)
    fun bindViewModel(authorizationViewModel: com.example.filmapps.featureRegAndAuth.featureAuthorization.presentation.viewModel.AuthorizationViewModel): ViewModel
}