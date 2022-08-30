package com.example.filmapps.featureAuthRegApi.featureAuthorizationApi.domain.useCase

import com.example.filmapps.featureRegAndAuth.domain.model.UserDataParam
import com.example.filmapps.featureRegAndAuth.presentation.model.Result


interface GetInfoAboutRegisterUseCase {
    suspend fun execute(param: UserDataParam): Result
}