package com.example.eroto.model.portfolio

import com.example.eroto.factories.PortfolioItemFactory
import com.example.eroto.models.PortfolioItemList

class PortfolioModelImpl: PortfolioModel {
    override fun getPortfolio(): PortfolioItemList {
        return PortfolioItemList(PortfolioItemFactory.generate(10))
    }
}