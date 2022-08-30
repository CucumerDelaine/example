package com.example.filmapps.featureRegAndAuth.featureAuthorization.domain.useCase

import com.example.filmapps.featureAuthRegApi.data.repository.UserRepositories
import com.example.filmapps.featureAuthRegApi.featureAuthorizationApi.domain.useCase.GetInfoAboutRegisterUseCase
import com.example.filmapps.featureRegAndAuth.domain.model.UserDataParam
import com.example.filmapps.featureRegAndAuth.presentation.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetInfoAboutRegisterUseCaseImpl @Inject constructor(
    private val authRepository: UserRepositories
) : GetInfoAboutRegisterUseCase {
    override suspend fun execute(param: UserDataParam): Result {
        return if (param.login.isEmpty() || param.pass.isEmpty())
            Result.Error("Поля не должны быть пустые")
        else {
            withContext(Dispatchers.IO) {
                try {
                    when (authRepository.isUserRegistered(userParam = param)) {
                        true -> Result.Success
                        false -> Result.Error("Error")
                    }
                } catch (e: Throwable) {
                    Result.Error("Error")
                }
            }
        }
    }

}