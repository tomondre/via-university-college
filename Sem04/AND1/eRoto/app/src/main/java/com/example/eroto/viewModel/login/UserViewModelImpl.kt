package com.example.eroto.viewModel.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.LoginUser
import com.example.eroto.models.User
import com.example.eroto.repository.user.UserRepository
import com.example.eroto.repository.user.UserWebClient

class UserViewModelImpl: ViewModel(), UserViewModel {

    private var userRepository: UserRepository = UserWebClient

    override fun performLogin(loginUser: LoginUser): LiveData<User> {
        return userRepository.performLogin(loginUser)
    }

    override fun createUser(user: User) : LiveData<User> {
        return userRepository   .createUser(user)
    }
}