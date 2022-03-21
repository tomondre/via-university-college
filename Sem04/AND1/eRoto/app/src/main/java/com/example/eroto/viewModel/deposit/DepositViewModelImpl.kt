package com.example.eroto.viewModel.deposit

import android.os.CountDownTimer
import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.CreditCard
import kotlin.collections.ArrayList

class DepositViewModelImpl: ViewModel(), DepositViewModel {

    private var list: MutableLiveData<List<CreditCard>> = MutableLiveData(ArrayList())

    init {
        var tempList: ArrayList<CreditCard> = ArrayList()

        tempList.add(CreditCard("1234", "Exp 05/24", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Mastercard-logo.svg/1200px-Mastercard-logo.svg.png"))
        tempList.add(CreditCard("1111", "Exp 03/22", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Mastercard-logo.svg/1200px-Mastercard-logo.svg.png"))
        tempList.add(CreditCard("2222", "Exp 06/25", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Mastercard-logo.svg/1200px-Mastercard-logo.svg.png"))
        tempList.add(CreditCard("3444", "Exp 06/26", "https://mininvestering.dk/wp-content/uploads/2020/06/visa-logo-1200x900.jpg"))
        object: CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                list.value = tempList
            }
        }.start()
    }

    override fun getSavedCreditCards(): LiveData<List<CreditCard>> {
        return list
    }
}