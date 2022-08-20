package com.example.filmapps.presentation.presenters

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmapps.R
import com.example.filmapps.Screens
import com.example.filmapps.feature.regAndAuth.presentation.model.Result
import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam
import com.example.filmapps.feature.regAndAuth.registrations.domain.useCase.SaveUserDataUseCase
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


internal class SaveUserDataViewModel @Inject constructor(
    private val saveUserDataUseCase: SaveUserDataUseCase,
    private val router: Router,
    private val context: Context
) : ViewModel() {

    private val _mutableState: MutableStateFlow<Result> = MutableStateFlow(Result.Loading)
    val mutableState: StateFlow<Result> = _mutableState

    fun goToAuth() {
        router.newChain(Screens.AuthorizationScreen())
    }

    fun registration(login: String, pass: String) {
        viewModelScope.launch {
            when (saveUserDataUseCase.execute(param = UserDataParam(login = login, pass = pass))) {
                is Result.Success -> _mutableState.emit(Result.Success)
                is Result.Error -> _mutableState.emit(Result.Error("${context.getString(R.string.badRed)}"))
                else -> {}
            }
        }
    }
}