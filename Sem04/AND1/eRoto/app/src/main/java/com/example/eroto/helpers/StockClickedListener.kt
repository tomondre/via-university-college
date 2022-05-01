package com.example.eroto.helpers

import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.Stock

interface StockClickedListener {
    fun onCellClickListener(item: Stock)
}