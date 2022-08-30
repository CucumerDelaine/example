package com.example.core_db_impl.data.repository

import com.example.core_db_api.data.UserDataRepository
import com.example.core_db_api.model.User
import com.example.core_db_impl.data.db.UserDataDAO
import com.example.core_db_impl.data.model.UserData
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val userDataDAO: UserDataDAO
) : UserDataRepository {

    override fun getUserData(login: String, pass: String): User? {
        val userData = userDataDAO.getUserData(login, pass) ?: return null
        return User(userData.login, userData.pass)
    }

    override fun save(user: User) {
        userDataDAO.insert(UserData(user.login, user.pass))
    }
}