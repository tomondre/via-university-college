package com.example.eroto.repository.portfolio

import androidx.lifecycle.LiveData
import com.example.eroto.models.PortfolioItem
import com.example.eroto.models.PortfolioItemList

interface PortfolioRepository {
 fun getPortfolio(): LiveData<List<PortfolioItem>>;
}