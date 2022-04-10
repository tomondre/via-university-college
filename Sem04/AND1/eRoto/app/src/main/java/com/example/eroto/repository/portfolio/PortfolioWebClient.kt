package com.example.eroto.repository.portfolio

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.eroto.helpers.Helper
import com.example.eroto.models.PortfolioItem

object PortfolioWebClient: PortfolioRepository{

    override fun getPortfolio(): LiveData<List<PortfolioItem>> {
        var portfolio = MutableLiveData<List<PortfolioItem>>(ArrayList<PortfolioItem>())
        object: CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                portfolio.value = Helper.getPortfolioStocks()
            }
        }.start()
        return portfolio
    }
}