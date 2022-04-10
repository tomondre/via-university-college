package com.example.eroto.viewModel.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.*
import com.example.eroto.repository.bigMover.BigMoverRepository
import com.example.eroto.repository.bigMover.BigMoverWebClient
import com.example.eroto.repository.market.MarketRepository
import com.example.eroto.repository.market.MarketWebClient
import com.example.eroto.repository.portfolioOverview.PortfolioOverviewRepository
import com.example.eroto.repository.portfolioOverview.PortfolioOverviewWebClient
import com.example.eroto.repository.post.PostRepository
import com.example.eroto.repository.post.PostWebClient
import com.github.mikephil.charting.data.Entry

class HomePageViewModelImpl : ViewModel(), HomePageViewModel {

    private var postRepository = PostWebClient
    private var portfolioOverviewRepository: PortfolioOverviewRepository = PortfolioOverviewWebClient
    private var bigMoverRepository: BigMoverRepository = BigMoverWebClient
    private var marketRepository: MarketRepository = MarketWebClient

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