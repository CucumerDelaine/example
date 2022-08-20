package com.example.filmapps.feature.regAndAuth.registrations.domain.useCase

import com.example.filmapps.feature.regAndAuth.presentation.model.Result
import com.example.filmapps.feature.regAndAuth.data.repositories.UserRepositories
import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class SaveUserDataUseCaseImpl @Inject constructor(
    private val userRepository: UserRepositories
) : SaveUserDataUseCase {
    override suspend fun execute(param: UserDataParam): Result {
        return if (param.login.isEmpty() || param.pass.isEmpty())
            Result.Error("Error")
        else {
            withContext(Dispatchers.IO) {
                try {
                    userRepository.save(userParam = param)
                    Result.Success
                } catch (e: Throwable) {
                    Result.Error("Error")
                }
            }
        }
    }
}