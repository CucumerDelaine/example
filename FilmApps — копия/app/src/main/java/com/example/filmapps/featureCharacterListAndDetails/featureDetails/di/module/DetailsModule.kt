package com.example.filmapps.featureCharacterListAndDetails.featureDetails.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.app.di.module.ViewModelKey
import com.example.filmapps.featureCharDetailsApi.featureDetailsApi.data.repository.GetCharacterRepository
import com.example.filmapps.featureCharDetailsApi.featureDetailsApi.domain.useCase.GetCharacterDetailsUseCase
import com.example.filmapps.featureCharDetailsApi.featureDetailsApi.presentation.model.ResultCharacterResponseModel
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.data.repository.GetCharacterRepositoryImpl
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.di.scope.DetailsScope
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.domain.useCase.GetCharacterDetailsUseCaseImpl
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.presentation.model.ResultCharacterResponseModelImpl
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.presentation.viewModel.CharacterDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface DetailsModule {

    @Binds
    @DetailsScope
    fun provideRetrofitRepositories(getCharacterRepository: GetCharacterRepositoryImpl) : GetCharacterRepository

    @Binds
    @DetailsScope
    fun provideGetCharacterDetailsUseCase(getCharacterDetailsUseCase: GetCharacterDetailsUseCaseImpl) : GetCharacterDetailsUseCase

    @Binds
    @IntoMap
    @ViewModelKey(CharacterDetailsViewModel::class)
    fun bindViewModel(characterDetailsViewModel: CharacterDetailsViewModel): ViewModel

    @Binds
    @DetailsScope
    fun provideCharacterConverter(characterConverter: ResultCharacterResponseModelImpl) : ResultCharacterResponseModel
}