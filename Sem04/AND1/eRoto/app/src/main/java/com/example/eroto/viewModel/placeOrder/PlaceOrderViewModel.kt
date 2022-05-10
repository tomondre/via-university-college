package com.example.eroto.viewModel.placeOrder

import androidx.lifecycle.LiveData
import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.Stock
import com.example.eroto.models.User

interface PlaceOrderViewModel {
    fun getLoggedInUser(): LiveData<User>
    fun placeBuyOrder(value: Double)
    fun getCurrentStock(): LiveData<Stock>
}