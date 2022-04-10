package com.example.eroto.repository.portfolioOverview

import androidx.lifecycle.LiveData
import com.example.eroto.models.PortfolioOverview

interface PortfolioOverviewRepository {
    fun getPortfolioOverview(): LiveData<PortfolioOverview>
}