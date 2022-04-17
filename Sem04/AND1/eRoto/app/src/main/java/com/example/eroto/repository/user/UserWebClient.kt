package com.example.eroto.repository.user

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.eroto.models.LoginUser
import com.example.eroto.models.User
import java.lang.Exception
import java.util.*

object UserWebClient : UserRepository {
    override fun performLogin(loginUser: LoginUser): LiveData<User> {

        var data = MutableLiveData<User>()

        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
//                throw Exception("Wrong login matafaka")
                data.value = User("Tomasito", "Halabala", "halabala")
            }
        }.start()
        return data
    }

    override fun createUser(user: User): LiveData<User> {
        return MutableLiveData(User("Tomasito", "Halabala", "halabala"))
    }
}