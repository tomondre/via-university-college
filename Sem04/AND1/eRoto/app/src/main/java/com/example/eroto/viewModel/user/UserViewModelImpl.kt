package com.example.eroto.viewModel.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.Helper
import com.example.eroto.models.LoginUser
import com.example.eroto.models.User
import com.example.eroto.repository.user.UserRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

class UserViewModelImpl : ViewModel(), UserViewModel {

    private var userRepository = UserRepository

    override fun performLogin(user: LoginUser) {
        Helper.validateEmailAndPassword(user.email, user.password)
        return userRepository.performLogin(user)
    }

    override fun createUser(user: User) {
        Helper.validateEmailAndPassword(user.email, user.password)
        userRepository.createUser(user)
    }

    override fun getLoginResponse(): LiveData<Task<AuthResult>> {
        return userRepository.getLoginResponse()
    }

    override fun getSignUpResponse(): LiveData<Task<AuthResult>> {
        return userRepository.getSignUpResponse()
    }
}