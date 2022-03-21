package com.example.eroto.viewModel.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.PortfolioItemList

interface PortfolioViewModel {
    fun getPortfolio(): LiveData<List<PortfolioItem>>
}