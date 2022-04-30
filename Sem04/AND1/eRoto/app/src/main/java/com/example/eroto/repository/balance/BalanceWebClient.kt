package com.example.eroto.repository.balance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.eroto.models.Balance
import com.example.eroto.models.BalanceLiveData
import com.example.eroto.repository.user.UserRepository
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object BalanceWebClient {
    var balance: BalanceLiveData
        private set
    private var myRef: DatabaseReference

    init {
        val uid = UserRepository.getLoggedInUser().value?.uid
        myRef = FirebaseDatabase.getInstance("https://and-eroto-default-rtdb.europe-west1.firebasedatabase.app/").reference.child("users").child(uid.toString())
            .child("balance")
        balance = BalanceLiveData(myRef)
    }


    fun addBalance(amount: Double) {
        myRef.setValue(balance.value?.let { it.balance + amount})
        //        if (balance.value != null) {
//            balance.value = Balance(balance.value!!.balance + amount)
//        }
    }
}