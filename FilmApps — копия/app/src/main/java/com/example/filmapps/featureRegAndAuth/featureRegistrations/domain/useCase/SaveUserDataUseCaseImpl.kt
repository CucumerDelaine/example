package com.example.filmapps.featureRegAndAuth.featureRegistrations.domain.useCase

import com.example.filmapps.featureAuthRegApi.data.repository.UserRepositories
import com.example.filmapps.featureAuthRegApi.featureRegistrationApi.domain.useCase.SaveUserDataUseCase
import com.example.filmapps.featureRegAndAuth.domain.model.UserDataParam
import com.example.filmapps.featureRegAndAuth.presentation.model.Result
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