package com.example.eroto.helpers

import com.example.eroto.models.PortfolioItem

interface PortfolioItemClickedListener {
    fun onCellClickListener(item: PortfolioItem)
}