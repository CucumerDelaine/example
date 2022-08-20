package com.example.filmapps.feature.regAndAuth.data.repositories


import com.example.filmapps.feature.regAndAuth.data.bd.UserDataDAO
import com.example.filmapps.feature.regAndAuth.data.model.UserData
import com.example.filmapps.feature.regAndAuth.domain.model.UserDataParam
import javax.inject.Inject

internal class UserRepositoriesImpl @Inject constructor(
    private val userData: UserDataDAO
) : UserRepositories {
    override fun save(userParam: UserDataParam) {
        userData.insert(userData = UserData(login = userParam.login, pass = userParam.pass))
    }

    override fun isUserRegistered(userParam: UserDataParam): Boolean {
        val user: UserData? = userData.getUserData(login = userParam.login, pass = userParam.pass)
        return user != null
    }
}