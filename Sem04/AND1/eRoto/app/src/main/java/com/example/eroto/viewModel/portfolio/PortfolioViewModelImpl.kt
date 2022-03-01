package com.example.eroto.viewModel.portfolio

import androidx.lifecycle.ViewModel
import com.example.eroto.helpers.Helper
import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.PortfolioItemList

class PortfolioViewModelImpl : ViewModel(), PortfolioViewModel {
    override fun getPortfolio(): PortfolioItemList {
        return PortfolioItemList(Helper.getPortfolioStocks())
    }
}