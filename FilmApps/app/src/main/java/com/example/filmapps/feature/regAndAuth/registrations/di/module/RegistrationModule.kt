package com.example.filmapps.feature.regAndAuth.registrations.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.feature.regAndAuth.data.repositories.UserRepositories
import com.example.filmapps.feature.regAndAuth.data.repositories.UserRepositoriesImpl
import com.example.filmapps.feature.regAndAuth.di.module.ViewModelKey
import com.example.filmapps.feature.regAndAuth.registrations.di.scope.RegistrationScope
import com.example.filmapps.feature.regAndAuth.registrations.domain.useCase.SaveUserDataUseCase
import com.example.filmapps.feature.regAndAuth.registrations.domain.useCase.SaveUserDataUseCaseImpl
import com.example.filmapps.presentation.presenters.SaveUserDataViewModel
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