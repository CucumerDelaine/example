package com.example.filmapps.featureRegAndAuth.featureRegistrations.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.app.presentation.presenters.SaveUserDataViewModel
import com.example.filmapps.app.di.module.ViewModelKey
import com.example.filmapps.featureAuthRegApi.data.repository.UserRepositories
import com.example.filmapps.featureAuthRegApi.featureRegistrationApi.domain.useCase.SaveUserDataUseCase
import com.example.filmapps.featureRegAndAuth.data.repositories.UserRepositoriesImpl
import com.example.filmapps.featureRegAndAuth.featureRegistrations.di.scope.RegistrationScope
import com.example.filmapps.featureRegAndAuth.featureRegistrations.domain.useCase.SaveUserDataUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface RegistrationModule {

    @Binds
    @RegistrationScope
    fun provideUserRepositories(userRepositories: UserRepositoriesImpl) : UserRepositories

    @Binds
    @RegistrationScope
    fun provideSaveUserDataUseCase(saveUserDataUseCase: SaveUserDataUseCaseImpl) : SaveUserDataUseCase

    @Binds
    @IntoMap
    @ViewModelKey(SaveUserDataViewModel::class)
    fun bindViewModel(saveUserDataViewModel: SaveUserDataViewModel): ViewModel
}