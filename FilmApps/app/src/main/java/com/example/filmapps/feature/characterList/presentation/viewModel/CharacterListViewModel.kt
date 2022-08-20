package com.example.filmapps.feature.characterList.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmapps.Screens
import com.example.filmapps.feature.characterListAndDetails.data.model.Character
import com.example.filmapps.feature.characterList.domain.useCase.ClearDatabaseUseCase
import com.example.filmapps.feature.characterList.domain.useCase.GetCharacterListUseCase
import com.example.filmapps.feature.characterList.domain.useCase.LoadAndSaveCharacterListUseCase
import com.example.filmapps.feature.characterList.data.model.CharacterConverter
import com.example.filmapps.feature.characterList.presentation.model.CharacterListResult
import com.example.filmapps.feature.characterList.presentation.model.GetCharacterListResponse
import com.example.filmapps.feature.characterList.presentation.model.SaveCharacterListResult
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterListViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase,
    private val loadCharacterListUseCase: LoadAndSaveCharacterListUseCase,
    private val clearDatabaseUseCase: ClearDatabaseUseCase,
    private val router: Router
) : ViewModel() {


    private val _mutableState: MutableStateFlow<CharacterListResult> =
        MutableStateFlow(CharacterListResult.Loading)
    val mutableState: StateFlow<CharacterListResult> = _mutableState
    private var page = 0


    fun pageNull() {
        page = 0
    }

    fun goToDetails(character: Character) {
        router.newChain(Screens.Details(character))
    }


    fun clearDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val getResult = getCharacterListUseCase.execute()) {
                is GetCharacterListResponse.Success -> clearDatabaseUseCase.execute(getResult.value)
                is GetCharacterListResponse.Error -> Unit
            }
        }
    }


    private suspend fun getCharacterList(): CharacterListResult {
       return when (val getResult = getCharacterListUseCase.execute()) {
            is GetCharacterListResponse.Success -> CharacterListResult.Success(getResult.value)
            is GetCharacterListResponse.Error -> CharacterListResult.Error(getResult.message)
        }
    }

    fun loadCharacterList(ignoreCache: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            page++
            if (page == 43)
                _mutableState.emit(CharacterListResult.Finally)
            else {
                when(val result = loadCharacterListUseCase.execute(page, ignoreCache)) {
                    is SaveCharacterListResult.Success -> _mutableState.emit(getCharacterList())
                    is SaveCharacterListResult.Error -> _mutableState.emit(CharacterListResult.Error(result.message))
                }
            }
        }
    }
}