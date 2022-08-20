package com.example.filmapps.feature.regAndAuth.authorization.domain.useCase

import com.example.filmapps.feature.regAndAuth.presentation.model.Result
import com.example.filmapps.feature.regAndAuth.data.repositories.UserRepositories
import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetInfoAboutRegisterUseCaseImpl @Inject constructor(
    private val userRepository: UserRepositories
) : GetInfoAboutRegisterUseCase {
    override suspend fun execute(param: UserDataParam): Result {
        return if (param.login.isEmpty() || param.pass.isEmpty())
            Result.Error("Поля не должны быть пустые")
        else {
            withContext(Dispatchers.IO) {
                try {
                    when (userRepository.isUserRegistered(userParam = param)) {
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



