package com.example.eroto.viewModel.placeOrder

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.BalanceLiveData
import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.Stock
import com.example.eroto.models.User
import com.example.eroto.repository.balance.BalanceRepository
import com.example.eroto.repository.portfolioOverview.PortfolioOverviewRepository
import com.example.eroto.repository.purchase.PurchaseRepository
import com.example.eroto.repository.stock.StockRepository
import com.example.eroto.repository.user.UserRepository

class PlaceOrderViewModelImpl: ViewModel(), PlaceOrderViewModel {

    private var stockRepository = StockRepository
    private var orderRepository = PurchaseRepository
    private var portfolioOverview = PortfolioOverviewRepository
    private var balanceRepository = BalanceRepository

    override fun getBalance(): BalanceLiveData {
        return balanceRepository.getBalance()
    }

    override fun placeBuyOrder(value: Double) {
        val balance = balanceRepository.getBalance().value!!.balance
        if (balance < value) {
            throw Exception("Insufficient funds!")
        }
        val stock = getCurrentStock().value!!
        val stockPrice = stock.currentPrice
        balanceRepository.removeBalance(value)
        portfolioOverview.addPortfolioValue(value)
        var numberOfStocks = value / stockPrice
        var portfolioItem = PortfolioItem(stock, value, numberOfStocks)
        orderRepository.placeBuyOrder(portfolioItem)
    }

    override fun getCurrentStock(): LiveData<Stock> {
        return stockRepository.getStockByTicker()
    }
}