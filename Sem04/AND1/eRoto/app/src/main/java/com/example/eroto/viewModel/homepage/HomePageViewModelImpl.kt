package com.example.eroto.viewModel.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.*
import com.example.eroto.repository.portfolioOverview.PortfolioOverviewRepository
import com.example.eroto.repository.portfolioOverview.PortfolioOverviewWebClient
import com.example.eroto.repository.post.PostRepository
import com.example.eroto.repository.post.PostWebClient
import com.github.mikephil.charting.data.Entry

class HomePageViewModelImpl : ViewModel(), HomePageViewModel {

    private var postRepository = PostWebClient
    private var portfolioOverviewRepository: PortfolioOverviewRepository = PortfolioOverviewWebClient

    override fun getPortfolioOverview(): LiveData<PortfolioOverview> {
        return portfolioOverviewRepository.getPortfolioOverview()
    }

    override fun getBigMoverGraphData(): BigMoverList {
        var entries = ArrayList<BigMover>()
        entries.add(BigMover("AYX", "https://etoro-cdn.etorostatic.com/market-avatars/7991/150x150.png", 11.78f))
        entries.add(BigMover("CRSR", "https://etoro-cdn.etorostatic.com/market-avatars/btc/70x70.png", 9.66f))
        entries.add(BigMover("PCG", "https://etoro-cdn.etorostatic.com/market-avatars/tsla/150x150.png", 2.98f))
        entries.add(BigMover("DOYU", "https://etoro-cdn.etorostatic.com/market-avatars/aapl/150x150.png", 2.01f))
        entries.add(BigMover("BNGO", "https://etoro-cdn.etorostatic.com/market-avatars/baba/150x150.png", 1.83f))

        return BigMoverList(entries)
    }

    override fun getMarketsData(): MarketDataList {
        var markets = ArrayList<MarketData>()
        markets.add(MarketData("NSDQ100", 1222.2, 0.5))
        markets.add(MarketData("SPY50", 1222.0, 0.5))
        markets.add(MarketData("HLABAALA100", 1222.2, 0.5))
        markets.add(MarketData("HUN10", 122.2, 0.5))
        markets.add(MarketData("MSCW100", 122.2, 0.5))
        markets.add(MarketData("HUN10", 122.2, 0.5))
        return MarketDataList(markets)
    }

    override fun getPosts(): LiveData<List<Post>> {
       return postRepository.getMainPosts()
    }
}