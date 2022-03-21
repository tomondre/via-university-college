package com.example.eroto.viewModel.portfolio

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.helpers.Helper
import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.PortfolioItemList

class PortfolioViewModelImpl : ViewModel(), PortfolioViewModel {
    private var portfolio: MutableLiveData<List<PortfolioItem>> = MutableLiveData(ArrayList())

    init {
        object: CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                portfolio.value = Helper.getPortfolioStocks()
            }
        }.start()
    }

    override fun getPortfolio(): LiveData<List<PortfolioItem>> {
        return portfolio
    }
}