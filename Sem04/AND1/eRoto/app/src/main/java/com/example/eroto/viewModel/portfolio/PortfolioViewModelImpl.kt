package com.example.eroto.viewModel.portfolio

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.helpers.Helper
import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.PortfolioItemList
import com.example.eroto.repository.portfolio.PortfolioRepository
import com.example.eroto.repository.portfolio.PortfolioWebClient

class PortfolioViewModelImpl : ViewModel(), PortfolioViewModel {

    private var portfolioRepository: PortfolioRepository = PortfolioWebClient

    override fun getPortfolio(): LiveData<List<PortfolioItem>> {
        return portfolioRepository.getPortfolio()
    }
}