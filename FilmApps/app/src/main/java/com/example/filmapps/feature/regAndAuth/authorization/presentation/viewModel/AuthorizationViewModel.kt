package com.example.filmapps.feature.regAndAuth.authorization.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmapps.R
import com.example.filmapps.Screens
import com.example.filmapps.feature.regAndAuth.authorization.domain.useCase.GetInfoAboutRegisterUseCase
import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam
import com.example.filmapps.feature.regAndAuth.presentation.model.Result
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class AuthorizationViewModel @Inject constructor(
    private val getInfoAboutRegisterUseCase: GetInfoAboutRegisterUseCase,
    private val router: Router,
    private val context: Context
) : ViewModel() {


    private val _mutableState: MutableStateFlow<Result> = MutableStateFlow(Result.Loading)
    val mutableState: StateFlow<Result> = _mutableState

    fun goToMain() {
        router.backTo(Screens.RegistrationScreen())
    }

    fun goToFilm() {
        router.newChain(Screens.ListFilmScreen())
    }

    fun auth(login: String, pass: String) {
        viewModelScope.launch {
            when (getInfoAboutRegisterUseCase.execute(
                param = UserDataParam(
                    login = login,
                    pass = pass
                )
            )
            ) {
                is Result.Success -> _mutableState.emit(Result.Success)
                is Result.Error -> _mutableState.emit(Result.Error("${context.getString(R.string.badAuth)}"))
                else -> {}
            }
        }
    }
}