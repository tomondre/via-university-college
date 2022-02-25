package com.example.eroto.model.portfolio

import com.example.eroto.models.PortfolioItemList

interface PortfolioModel {
    fun getPortfolio(): PortfolioItemList
}