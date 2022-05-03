package com.example.eroto.viewModel.placeOrder

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.Stock
import com.example.eroto.models.User
import com.example.eroto.repository.purchase.PurchaseRepository
import com.example.eroto.repository.stock.StockRepository
import com.example.eroto.repository.user.UserRepository

class PlaceOrderViewModelImpl: ViewModel(), PlaceOrderViewModel {

    private var userRepository = UserRepository
    private var stockRepository = StockRepository
    private var purchaseRepository = PurchaseRepository


    override fun getLoggedInUser(): LiveData<User> {
        return userRepository.getLoggedInUser()
    }

    override fun placeOrder(item: PortfolioItem) {
        purchaseRepository.purchaseStock(item)
    }

    override fun getCurrentStock(): LiveData<Stock> {
        return stockRepository.getStockByTicker()
    }
}