package com.example.eroto.viewModel.portfolio

import androidx.lifecycle.ViewModel
import com.example.eroto.models.PortfolioItemList

interface PortfolioViewModel {
    fun getPortfolio(): PortfolioItemList
}