package com.example.filmapps.feature.regAndAuth.registrations.domain.useCase

import com.example.filmapps.feature.regAndAuth.presentation.model.Result
import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam

interface SaveUserDataUseCase {
    suspend fun execute(param: UserDataParam): Result
}