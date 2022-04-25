package com.example.eroto.viewModel.user

import androidx.lifecycle.LiveData
import com.example.eroto.models.LoginUser
import com.example.eroto.models.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface UserViewModel {
    fun performLogin(user: LoginUser)
    fun createUser(user: User)
    fun getLoginResponse(): LiveData<Task<AuthResult>>
    fun getSignUpResponse(): LiveData<Task<AuthResult>>
}