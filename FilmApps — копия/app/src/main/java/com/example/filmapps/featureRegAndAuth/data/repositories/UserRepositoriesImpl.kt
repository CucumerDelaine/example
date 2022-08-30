package com.example.filmapps.featureRegAndAuth.data.repositories


import com.example.core_db_api.data.UserDataRepository
import com.example.core_db_api.model.User
import com.example.filmapps.featureAuthRegApi.data.repository.UserRepositories
import com.example.filmapps.featureRegAndAuth.domain.model.UserDataParam
import javax.inject.Inject

internal class UserRepositoriesImpl @Inject constructor(
    private val userDataRepository: UserDataRepository
) : UserRepositories {
    override fun save(userParam: UserDataParam) {
        userDataRepository.save(User(userParam.login, userParam.pass))
    }

    override fun isUserRegistered(userParam: UserDataParam): Boolean {
        val user = userDataRepository.getUserData(login = userParam.login, pass = userParam.pass)
        return user != null
    }
}