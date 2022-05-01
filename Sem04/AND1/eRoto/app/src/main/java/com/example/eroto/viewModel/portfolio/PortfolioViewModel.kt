package com.example.eroto.viewModel.portfolio

import androidx.lifecycle.LiveData
import com.example.eroto.models.PortfolioItem

interface PortfolioViewModel {
    fun getPortfolio(): LiveData<List<PortfolioItem>>
}