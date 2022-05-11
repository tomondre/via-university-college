package com.example.eroto.viewModel.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.PortfolioOverview
import com.example.eroto.repository.balance.BalanceRepository
import com.example.eroto.repository.portfolio.PortfolioRepository
import com.example.eroto.repository.portfolioOverview.PortfolioOverviewRepository
import com.example.eroto.repository.user.UserRepository

class PortfolioViewModelImpl : ViewModel(), PortfolioViewModel {

    private var portfolioRepository = PortfolioRepository
    private var portfolioOverview = PortfolioOverviewRepository
    private var balanceRepository = BalanceRepository

    override fun getPortfolio(): LiveData<List<PortfolioItem>> {
        return portfolioRepository.getPortfolio()
    }

    override fun closePortfolioItem(item: PortfolioItem) {
        portfolioOverview.removePortfolioValue(item.valueInvested)
        balanceRepository.addBalance(item.valueInvested)
        portfolioRepository.closePortfolioItem(item)
    }
}