package com.example.eroto

import com.example.eroto.models.PortfolioItem

interface PortfolioItemStockListener {
    fun onCellClickListener(item: PortfolioItem)
}