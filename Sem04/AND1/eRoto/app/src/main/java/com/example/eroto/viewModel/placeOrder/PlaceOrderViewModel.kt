package com.example.eroto.viewModel.placeOrder

import androidx.lifecycle.LiveData
import com.example.eroto.models.BalanceLiveData
import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.Stock
import com.example.eroto.models.User

interface PlaceOrderViewModel {
    fun getBalance(): BalanceLiveData
    fun placeBuyOrder(value: Double)
    fun getCurrentStock(): LiveData<Stock>
}