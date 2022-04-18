package com.example.eroto.viewModel.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.*
import com.example.eroto.repository.bigMover.BigMoverRepositoryImpl
import com.example.eroto.repository.market.MarketRepositoryImpl
import com.example.eroto.repository.portfolioOverview.PortfolioOverviewRepositoryImpl
import com.example.eroto.repository.post.PostWebClient

class HomePageViewModelImpl : ViewModel(), HomePageViewModel {

    private var postRepository = PostWebClient
    private var portfolioOverviewRepository = PortfolioOverviewRepositoryImpl()
    private var bigMoverRepository = BigMoverRepositoryImpl()
    private var marketRepository = MarketRepositoryImpl()

    override fun getPortfolioOverview(): LiveData<PortfolioOverview> {
        return portfolioOverviewRepository.getPortfolioOverview()
    }

    override fun getBigMoverGraphData(): LiveData<List<BigMover>> {
        return bigMoverRepository.getBigMoverGraphData()
    }

    override fun getMarketsData(): LiveData<List<MarketData>> {
        return marketRepository.getMarketsData()
    }

    override fun getPosts(): LiveData<List<Post>> {
       return postRepository.getMainPosts()
    }
}