package com.example.eroto.repository.creditCard

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.eroto.models.CreditCard
import com.example.eroto.models.CreditCardList

object CreditCardWebClient {
    fun getSavedCreditCards(): LiveData<List<CreditCard>> {
        var list = MutableLiveData<List<CreditCard>>(ArrayList<CreditCard>())
//        object: CountDownTimer(2000, 1000) {
//            override fun onTick(millisUntilFinished: Long) {}
//            override fun onFinish() {
                var tempList: ArrayList<CreditCard> = ArrayList()

                tempList.add(CreditCard("1234", "Exp 05/24", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Mastercard-logo.svg/1200px-Mastercard-logo.svg.png"))
                tempList.add(CreditCard("1111", "Exp 03/22", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Mastercard-logo.svg/1200px-Mastercard-logo.svg.png"))
                tempList.add(CreditCard("2222", "Exp 06/25", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Mastercard-logo.svg/1200px-Mastercard-logo.svg.png"))
                tempList.add(CreditCard("3444", "Exp 06/26", "https://mininvestering.dk/wp-content/uploads/2020/06/visa-logo-1200x900.jpg"))
                list.value = tempList
//            }
//        }.start()
        return list
    }
}