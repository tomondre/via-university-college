package com.example.eroto.viewModel.portfolio

import com.example.eroto.factories.PortfolioItemFactory
import com.example.eroto.models.PortfolioItemList

class PortfolioViewModelImpl: PortfolioViewModel {
    override fun getPortfolio(): PortfolioItemList {
        return PortfolioItemList(PortfolioItemFactory.generate(10))
    }
}