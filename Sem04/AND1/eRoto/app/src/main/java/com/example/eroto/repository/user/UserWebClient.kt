package com.example.eroto.repository.user

import androidx.lifecycle.MutableLiveData
import com.example.eroto.Helper
import com.example.eroto.models.*
import com.example.eroto.repository.portfolioOverview.PortfolioOverviewWebClient
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

object UserWebClient {

    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    var loggedInUser = UserLiveData()
        private set

    var loginResponse = MutableLiveData<Task<AuthResult>>()
        private set

    var signUpResponse = MutableLiveData<Task<AuthResult>>()
        private set

    fun performLogin(loginUser: LoginUser) {
        mAuth.signInWithEmailAndPassword(loginUser.email, loginUser.password)
            .addOnCompleteListener {
                loginResponse.value = it
                loggedInUser = UserLiveData(Helper.getLoggedInUserDatabaseReference())
            }
    }

    fun createUser(user: User) {
        mAuth.createUserWithEmailAndPassword(user.email, user.password).addOnCompleteListener {
            if (it.isSuccessful) {

                createUserValuesInDb(user)

                loggedInUser = UserLiveData(Helper.getLoggedInUserDatabaseReference())
            }

            signUpResponse.value = it
        }
    }

    private fun createUserValuesInDb(user: User) {
        val userReference = Helper.getLoggedInUserDatabaseReference()
        val databaseUser = DatabaseUser(user)
        databaseUser.graphData.add(0.0)
        databaseUser.graphData.add(0.0)
        userReference.setValue(databaseUser)
    }

    fun reduceBalance(value: Double) {
        val userBalanceReference = Helper.getUserBalanceReference()
        val newValue = loggedInUser.value!!.balance.balance - value
        userBalanceReference.setValue(Balance(newValue))
    }

    fun increaseBalance(value: Double) {
        val userBalanceReference = Helper.getUserBalanceReference()
        val newValue = loggedInUser.value!!.balance.balance + value
        userBalanceReference.setValue(Balance(newValue))
    }
}