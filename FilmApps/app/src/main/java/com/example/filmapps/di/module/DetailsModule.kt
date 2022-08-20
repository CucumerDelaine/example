package com.example.filmapps.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.data.repository.GetCharacterRepository
import com.example.filmapps.data.repository.GetCharacterRepositoryImpl
import com.example.filmapps.di.scope.CharacterScope
import com.example.filmapps.domain.useCase.GetCharacterDetailsUseCase
import com.example.filmapps.domain.useCase.GetCharacterDetailsUseCaseImpl
import com.example.filmapps.feature.regAndAuth.di.module.ViewModelKey
import com.example.filmapps.presentation.ui.ResultCharacterResponseModel
import com.example.filmapps.presentation.ui.ResultCharacterResponseModelImpl
import com.example.filmapps.presentation.viewModel.CharacterDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface DetailsModule {

    @Binds
    @CharacterScope
    fun provideRetrofitRepositories(getCharacterRepository: GetCharacterRepositoryImpl) : GetCharacterRepository

    @Binds
    @CharacterScope
    fun provideGetCharacterDetailsUseCase(getCharacterDetailsUseCase: GetCharacterDetailsUseCaseImpl) : GetCharacterDetailsUseCase

    @Binds
    @IntoMap
    @ViewModelKey(CharacterDetailsViewModel::class)
    fun bindViewModel(characterDetailsViewModel: CharacterDetailsViewModel): ViewModel

    @Binds
    @CharacterScope
    fun provideCharacterConverter(characterConverter: ResultCharacterResponseModelImpl) : ResultCharacterResponseModel
}