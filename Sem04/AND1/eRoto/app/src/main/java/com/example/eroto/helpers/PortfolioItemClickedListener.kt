package com.example.eroto.helpers

import com.example.eroto.models.PortfolioItem

interface PortfolioItemClickedListener {
    fun onPortfolioClickListener(item: PortfolioItem)
    fun onClosePortfolioItemListener(item: PortfolioItem)
}