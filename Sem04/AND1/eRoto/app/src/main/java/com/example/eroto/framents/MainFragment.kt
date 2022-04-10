package com.example.eroto.framents

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eroto.R
import com.example.eroto.adapters.BigMoversAdapter
import com.example.eroto.adapters.MarketAdapter
import com.example.eroto.adapters.PostsAdapter
import com.example.eroto.models.BigMover
import com.example.eroto.viewModel.homepage.HomePageViewModel
import com.example.eroto.viewModel.homepage.HomePageViewModelImpl
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.Utils


class MainFragment : Fragment() {
    private lateinit var bigMoverChart: BarChart
    private lateinit var lineChart: LineChart
    private lateinit var portfolioValueTextView: TextView
    private lateinit var portfolioDiffTextView: TextView

    private lateinit var bigMoverRecycler: RecyclerView
    private lateinit var marketRecycler: RecyclerView
    private lateinit var postsRecycler: RecyclerView

    private var bigMoverAdapter: BigMoversAdapter = BigMoversAdapter()
    private var marketAdapter: MarketAdapter = MarketAdapter()

    private lateinit var viewModel: HomePageViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomePageViewModelImpl::class.java)
        bigMoverChart = view.findViewById(R.id.bigMoversChart)
        lineChart = view.findViewById(R.id.lineChart)

        marketRecycler = view.findViewById(R.id.market_recycler)
        bigMoverRecycler = view.findViewById(R.id.big_movers_recycler)
        postsRecycler = view.findViewById(R.id.main_fragment_posts_recycler)

        portfolioValueTextView = view.findViewById(R.id.portfolio_value)
        portfolioDiffTextView = view.findViewById(R.id.day_profit_loss)

        viewModel.getPortfolioOverview().observe(viewLifecycleOwner) {
            loadPortfolioChartData(it.graphData)
            loadPortfolioData(it.currency, it.value, it.plValue, it.plPercent)
        }

        viewModel.getBigMoverGraphData().observe(viewLifecycleOwner) {
            loadBigMoverData(it)
        }

        viewModel.getMarketsData().observe(viewLifecycleOwner) {
            marketAdapter.marketList = it
        }

        createBigMovers()
        createBigMoverSection()
        createPortfolioView()
        createMarketView()
        createPostsData()
    }

    private fun loadPortfolioChartData(values: List<Entry>) {
        val lineDataSet = LineDataSet(values, "")

        lineDataSet.setDrawFilled(true)
        if (Utils.getSDKInt() >= 18) {
            val drawable =
                ContextCompat.getDrawable(activity?.applicationContext!!, R.drawable.fade)
            lineDataSet.fillDrawable = drawable
        } else {
            lineDataSet.fillColor = Color.parseColor("#4bdf2b")
        }

        lineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        lineDataSet.color = Color.parseColor("#4bdf2b")

        lineDataSet.setDrawValues(false)
        lineDataSet.setDrawCircles(false)
        lineDataSet.setDrawHorizontalHighlightIndicator(false)
        lineDataSet.setDrawVerticalHighlightIndicator(false)

        val lineData = LineData(lineDataSet)
        lineChart.data = lineData
    }

    private fun loadPortfolioData(
        currency: String,
        value: Double,
        plValue: Double,
        plPercent: Double
    ) {
        portfolioDiffTextView.text = "▲${currency}${plValue} (${plPercent}%)"
        portfolioValueTextView.text = "${currency}${value}"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

    private fun createPortfolioView() {
        lineChart.xAxis.isEnabled = false
        lineChart.axisLeft.isEnabled = false
        lineChart.axisRight.isEnabled = false

        lineChart.legend.isEnabled = false
        lineChart.description.isEnabled = false
        lineChart.setScaleEnabled(false)
    }

    private fun createMarketView() {

        var layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        marketRecycler.layoutManager = layoutManager
        marketRecycler.adapter = marketAdapter
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun createBigMoverSection() {
        bigMoverRecycler.setOnTouchListener { v, event -> true }
        bigMoverRecycler.adapter = bigMoverAdapter
    }

    private fun loadBigMoverData(data: List<BigMover>) {
        var temp = ArrayList<BarEntry>()

        for (i in data.indices) {
            temp.add(BarEntry(i.toFloat(), data[i].value))
        }

        var dataSet = BarDataSet(temp, "")
        dataSet.valueTextSize = 15f
        dataSet.setGradientColor(Color.parseColor("#41b727"), Color.parseColor("#4bdf2b"))
        dataSet.valueTextColor = Color.parseColor("#4ad929")
        dataSet.highLightAlpha = 0

        val barData = BarData(dataSet)
        barData.barWidth = 0.4f
        bigMoverChart.data = barData
        bigMoverChart.invalidate()

        bigMoverAdapter.bigMoverList = data
    }

    private fun createBigMovers() {
        bigMoverChart.axisLeft.isEnabled = false
        bigMoverChart.xAxis.isEnabled = false
        bigMoverChart.axisRight.isEnabled = false

        bigMoverChart.legend.isEnabled = false
        bigMoverChart.description.isEnabled = false
        bigMoverChart.setScaleEnabled(false)

        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        bigMoverRecycler.layoutManager = linearLayoutManager
    }

    private fun createPostsData() {
        val posts = viewModel.getPosts()
        val postsAdapter = PostsAdapter(posts.value!!)
        val linearLayoutManager = object : LinearLayoutManager(context) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }

        postsRecycler.adapter = postsAdapter
        postsRecycler.layoutManager = linearLayoutManager
    }
}
