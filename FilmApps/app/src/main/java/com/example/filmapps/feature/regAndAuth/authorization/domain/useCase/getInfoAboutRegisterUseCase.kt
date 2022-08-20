package com.example.filmapps.feature.regAndAuth.authorization.domain.useCase

import com.example.filmapps.feature.regAndAuth.presentation.model.Result
import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam

interface GetInfoAboutRegisterUseCase {
    suspend fun execute(param: UserDataParam): Result
}