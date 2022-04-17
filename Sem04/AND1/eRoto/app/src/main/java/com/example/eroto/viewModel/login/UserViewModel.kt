package com.example.eroto.viewModel.login

import androidx.lifecycle.LiveData
import com.example.eroto.models.LoginUser
import com.example.eroto.models.User

interface UserViewModel {
    fun performLogin(loginUser: LoginUser): LiveData<User>
    fun createUser(user: User): LiveData<User>
}