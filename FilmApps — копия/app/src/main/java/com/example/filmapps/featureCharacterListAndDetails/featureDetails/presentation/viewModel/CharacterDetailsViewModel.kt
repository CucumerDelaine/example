package com.example.filmapps.featureCharacterListAndDetails.featureDetails.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmapps.Screens
import com.example.filmapps.featureCharDetailsApi.featureDetailsApi.domain.useCase.GetCharacterDetailsUseCase
import com.example.filmapps.featureCharDetailsApi.featureDetailsApi.presentation.model.ResultCharacterResponseModel
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.presentation.model.CharacterDetailsResponse
import com.example.filmapps.featureCharacterListAndDetails.featureDetails.presentation.model.CharacterDetailsResult
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterDetailsViewModel @Inject constructor(
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase,
    private val characterConverter: ResultCharacterResponseModel,
    private val router: Router
) : ViewModel() {

    private val _mutableState: MutableStateFlow<CharacterDetailsResult> =
        MutableStateFlow(CharacterDetailsResult.Loading)
    val mutableState: StateFlow<CharacterDetailsResult> = _mutableState

    fun backToCharLIst() {
        router.backTo(Screens.ListFilmScreen())
    }


    fun getCharacterDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val it = getCharacterDetailsUseCase.execute(id)) {
                is CharacterDetailsResponse.Success -> _mutableState.emit(CharacterDetailsResult.Success(characterConverter.converter(it.value)))
                is CharacterDetailsResponse.Error -> _mutableState.emit(CharacterDetailsResult.Error(it.message.toString()))
            }
        }
    }
}