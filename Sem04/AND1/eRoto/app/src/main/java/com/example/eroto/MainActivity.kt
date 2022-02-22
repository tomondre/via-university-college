package com.example.eroto

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.Utils


class MainActivity : AppCompatActivity() {
    private lateinit var barChart: BarChart
    private lateinit var lineChart: LineChart
    private lateinit var marketLayout: LinearLayout
    private lateinit var burgerButton: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)

        burgerButton = findViewById(R.id.burgir)
        burgerButton.setOnClickListener(::clickedBurgir)

        barChart = findViewById(R.id.bigMoversChart)
        setupChart()

        marketLayout = findViewById(R.id.markets_data)

        lineChart = findViewById(R.id.lineChart)
        setUpLineChart()
        Log.d("Main Activity", "Create")
    }

    private fun clickedBurgir(v: View){
        Toast.makeText(this, "Menu open", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("Main Activity", "Pause")
    }

    override fun onStart() {
        super.onStart()

        loadPieChartData()
        loadLineChartData()
        loadMarketsData()
        Log.d("Main Activity", "Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Main Activity", "Resume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Main Activity", "Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main Activity", "Destroy")
    }

    private fun loadMarketsData() {
        var markets = ArrayList<Market>()
        markets.add(Market("NSDQ100", 1222.2, 0.5))
        markets.add(Market("NSDQ100", 1222.2, 0.5))
        markets.add(Market("NSDQ100", 1222.2, 0.5))
        markets.add(Market("NSDQ100", 1222.2, 0.5))

//        for (market in markets) {
//            var
//        }
//        marketLayout
    }

    private fun setUpLineChart() {
        lineChart.xAxis.isEnabled = false
        lineChart.axisLeft.isEnabled = false
        lineChart.axisRight.isEnabled = false

        lineChart.legend.isEnabled = false
        lineChart.description.isEnabled = false
        lineChart.setScaleEnabled(false)
    }

    private fun loadLineChartData() {
        var values = ArrayList<Entry>()
        values.add(Entry(10f, 10f))
        values.add(Entry(15f, 18f))
        values.add(Entry(30f, 15f))
        values.add(Entry(40f, 30f))
        values.add(Entry(50f, 25f))
        values.add(Entry(80f, 40f))
        values.add(Entry(100f, 30f))

        val lineDataSet = LineDataSet(values, "")

        lineDataSet.setDrawFilled(true)
        if (Utils.getSDKInt() >= 18) {
            val drawable = ContextCompat.getDrawable(this, R.drawable.fade)
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

    private fun setupChart() {
        barChart.axisLeft.isEnabled = false
        barChart.xAxis.isEnabled = false
        barChart.axisRight.isEnabled = false

        barChart.legend.isEnabled = false
        barChart.description.isEnabled = false
        barChart.setScaleEnabled(false)
    }

    private fun loadPieChartData() {
        var entries = ArrayList<BarEntry>()
        entries.add(BarEntry(1f, 11.78f))
        entries.add(BarEntry(2f, 9.66f))
        entries.add(BarEntry(3f, 2.98f))
        entries.add(BarEntry(4f, 2.01f))
        entries.add(BarEntry(5f, 1.83f))

        var dataSet = BarDataSet(entries, "")
        dataSet.valueTextSize = 15f
        dataSet.setGradientColor(Color.parseColor("#41b727"), Color.parseColor("#4bdf2b"))
        dataSet.valueTextColor = Color.parseColor("#4ad929")
        dataSet.highLightAlpha = 0
        val barData = BarData(dataSet)
        barData.barWidth = 0.4f
        barChart.data = barData
        barChart.invalidate()
    }
}

class Market(var ticker: String, var price: Double, var diff: Double) {

}