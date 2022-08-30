package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.di.module

import androidx.lifecycle.ViewModel
import com.example.filmapps.app.di.module.ViewModelKey
import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.model.CharacterConverter
import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.repository.CacheRepository
import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.data.repository.NetworkRepository
import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.domain.useCase.ClearDatabaseUseCase
import com.example.filmapps.featureCharDetailsApi.featureCharacterListApi.domain.useCase.GetAndSaveCharacterListUseCase
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.data.model.CharacterConverterImpl
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.data.repository.CacheRepositoryImpl
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.data.repository.NetworkRepositoryImpl
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.di.scope.CharacterListScope
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.domain.useCase.ClearDatabaseUseCaseImpl
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.domain.useCase.GetAndSaveCharacterListUseCaseImpl
import com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.viewModel.CharacterListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal interface CharacterListModule {

    @Binds
    @CharacterListScope
    fun provideCacheRepository(cacheRepository: CacheRepositoryImpl) : CacheRepository

    @Binds
    @CharacterListScope
    fun provideNetworkRepository(networkRepository: NetworkRepositoryImpl) : NetworkRepository

    @Binds
    @CharacterListScope
    fun provideClearDatabaseUseCase(clearDatabaseUseCase: ClearDatabaseUseCaseImpl) : ClearDatabaseUseCase

    @Binds
    @CharacterListScope
    fun provideLoadCharacterListUseCase(loadCharacterListUseCase: GetAndSaveCharacterListUseCaseImpl) : GetAndSaveCharacterListUseCase

    @Binds
    @IntoMap
    @ViewModelKey(CharacterListViewModel::class)
    fun bindViewModel(characterListViewModel: CharacterListViewModel): ViewModel

    @Binds
    @CharacterListScope
    fun provideCharacterListModel(characterListModel: CharacterConverterImpl) : CharacterConverter

}