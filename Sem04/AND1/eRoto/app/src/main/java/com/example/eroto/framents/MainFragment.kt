package com.example.eroto.framents

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eroto.R
import com.example.eroto.adapters.BigMoversAdapter
import com.example.eroto.adapters.MarketViewAdapter
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

    private lateinit var viewModel: HomePageViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomePageViewModelImpl::class.java)
        bigMoverChart = view.findViewById(R.id.bigMoversChart)
        lineChart = view.findViewById(R.id.lineChart)

        marketRecycler = view.findViewById(R.id.market_recycler)
        bigMoverRecycler = view.findViewById(R.id.big_movers_recycler)

        portfolioValueTextView = view.findViewById(R.id.portfolio_value)
        portfolioDiffTextView = view.findViewById(R.id.day_profit_loss)

        createPortfolioData()
        createBigMovers()
        createPortfolioView()
        createMarketView()
    }

    private fun createPortfolioData() {
        val portfolioData = viewModel.getPortfolioData()
        portfolioDiffTextView.text = portfolioData

        val portfolioValue = viewModel.getPortfolioValue()
        portfolioValueTextView.text = portfolioValue
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }


    private fun createPortfolioView() {
        lineChart.xAxis.isEnabled = false
        lineChart.axisLeft.isEnabled = false
        lineChart.axisRight.isEnabled = false

        lineChart.legend.isEnabled = false
        lineChart.description.isEnabled = false
        lineChart.setScaleEnabled(false)

        var values = viewModel.getPortfolioGraphData()
        val lineDataSet = LineDataSet(values, "")

        lineDataSet.setDrawFilled(true)
        if (Utils.getSDKInt() >= 18) {
            val drawable = ContextCompat.getDrawable(activity?.applicationContext!!, R.drawable.fade)
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

    private fun createMarketView() {
        var adapter = MarketViewAdapter()

        adapter.marketList = viewModel.getMarketsData().list

        var layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        marketRecycler.layoutManager = layoutManager
        marketRecycler.adapter = adapter
    }

    private fun createBigMovers() {
        bigMoverChart.axisLeft.isEnabled = false
        bigMoverChart.xAxis.isEnabled = false
        bigMoverChart.axisRight.isEnabled = false

        bigMoverChart.legend.isEnabled = false
        bigMoverChart.description.isEnabled = false
        bigMoverChart.setScaleEnabled(false)

        val data = viewModel.getBigMoverGraphData()

        var dataSet = BarDataSet(data.toEntries(), "")
        dataSet.valueTextSize = 15f
        dataSet.setGradientColor(Color.parseColor("#41b727"), Color.parseColor("#4bdf2b"))
        dataSet.valueTextColor = Color.parseColor("#4ad929")
        dataSet.highLightAlpha = 0
        val barData = BarData(dataSet)
        barData.barWidth = 0.4f
        bigMoverChart.data = barData
        bigMoverChart.invalidate()

        val bigMoversAdapter = BigMoversAdapter()
        bigMoversAdapter.bigMoverList = data.items

        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        bigMoverRecycler.layoutManager = linearLayoutManager
        bigMoverRecycler.adapter = bigMoversAdapter
    }
}
