package com.example.eroto.viewModel.deposit

import androidx.lifecycle.ViewModel
import com.example.eroto.models.CreditCard
import com.example.eroto.models.CreditCardList

class DepositViewModelImpl: ViewModel(), DepositViewModel {
    override fun getSavedCreditCards(): CreditCardList {
        var list: ArrayList<CreditCard> = ArrayList()

        list.add(CreditCard("1234", "Exp 05/24", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Mastercard-logo.svg/1200px-Mastercard-logo.svg.png"))
        list.add(CreditCard("1111", "Exp 03/22", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Mastercard-logo.svg/1200px-Mastercard-logo.svg.png"))
        list.add(CreditCard("2222", "Exp 06/25", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Mastercard-logo.svg/1200px-Mastercard-logo.svg.png"))
        list.add(CreditCard("3444", "Exp 06/26", "https://mininvestering.dk/wp-content/uploads/2020/06/visa-logo-1200x900.jpg"))
        return CreditCardList(list)
    }
}