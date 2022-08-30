package com.example.filmapps.featureAuthRegApi.featureRegistrationApi.domain.useCase

import com.example.filmapps.featureRegAndAuth.domain.model.UserDataParam
import com.example.filmapps.featureRegAndAuth.presentation.model.Result

interface SaveUserDataUseCase {
    suspend fun execute(param: UserDataParam): Result
}