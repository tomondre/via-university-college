package com.example.eroto.viewModel.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.PortfolioItem
import com.example.eroto.repository.portfolio.PortfolioRepository

class PortfolioViewModelImpl : ViewModel(), PortfolioViewModel {

    private var portfolioRepository = PortfolioRepository()

    override fun getPortfolio(): LiveData<List<PortfolioItem>> {
        return portfolioRepository.getPortfolio()
    }
}