package com.example.eroto.viewModel.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.*
import com.example.eroto.repository.bigMover.BigMoverRepository
import com.example.eroto.repository.market.MarketRepository
import com.example.eroto.repository.portfolioOverview.PortfolioOverviewRepository
import com.example.eroto.repository.post.PostRepository
import com.example.eroto.repository.post.PostWebClient

class HomePageViewModelImpl : ViewModel(), HomePageViewModel {

    private var postRepository = PostRepository
    private var portfolioOverviewRepository = PortfolioOverviewRepository
    private var bigMoverRepository = BigMoverRepository
    private var marketRepository = MarketRepository

    override fun getPortfolioOverview(): LiveData<PortfolioOverview> {
        return portfolioOverviewRepository.getPortfolioOverview()
    }

    override fun getBigMoverGraphData(): LiveData<List<BigMover>> {
        return bigMoverRepository.getBigMoverGraphData()
    }

    override fun getMarketsData(): MarketDataListLiveData {
        return marketRepository.getMarketsData()
    }

    override fun getPosts(): LiveData<List<Post>> {
       return postRepository.getMainPosts()
    }
}