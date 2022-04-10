package com.example.eroto.repository.market

import androidx.lifecycle.LiveData
import com.example.eroto.models.MarketData

interface MarketRepository {
    fun getMarketsData(): LiveData<List<MarketData>>
}