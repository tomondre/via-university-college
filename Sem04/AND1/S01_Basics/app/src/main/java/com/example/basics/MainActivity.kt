package com.example.basics

import android.graphics.Color
import android.graphics.LinearGradient
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.Utils


class MainActivity : AppCompatActivity() {
    private lateinit var barChart: BarChart
    private lateinit var lineChart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ex09_copy_a_layout)

        barChart = findViewById(R.id.bigMoversChart)
        loadPieChartData()
        setupChart()

        lineChart = findViewById(R.id.lineChart)
        loadLineChartData()
        setUpLineChart()

        Log.i("CREATE CALLED", "")
    }

    override fun onStart() {
        super.onStart()
        Log.i("START CALLED", "")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("RESTART CALLED", "")
    }

    override fun onStop() {
        Log.i("STOP CALLED", "")
        super.onStop()
    }

    override fun onPause() {
        super.onPause()
        Log.i("PAUSE CALLED", "")
    }

    override fun onResume() {
        super.onResume()
        Log.i("RESUME CALLED", "")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("DESTROY CALLED", "")
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.i("CREATE CALLED", "")
    }

    private fun setUpLineChart() {
        lineChart.xAxis.isEnabled = false
        lineChart.axisLeft.isEnabled = false
        lineChart.axisRight.isEnabled = false

        lineChart.legend.isEnabled = false
        lineChart.description.isEnabled = false

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
        }
        else {
            lineDataSet.fillColor = Color.parseColor("#4bdf2b")
        }

        lineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER

        lineDataSet.setDrawValues(false)
        lineDataSet.setDrawCircles(false)

        val lineData = LineData(lineDataSet)
        lineChart.data = lineData
    }

    private fun setupChart() {
        barChart.axisLeft.isEnabled = false
        barChart.xAxis.isEnabled = false
        barChart.axisRight.isEnabled = false

        barChart.legend.isEnabled = false
        barChart.description.isEnabled = false
    }

    private fun loadPieChartData() {
        var entries = ArrayList<BarEntry>()
        entries.add(BarEntry(1f, 11.78f))
        entries.add(BarEntry(2f, 9.66f))
        entries.add(BarEntry(3f, 2.98f))
        entries.add(BarEntry(4f, 2.01f))
        entries.add(BarEntry(5f, 1.83f))

        var dataSet = BarDataSet(entries, "")
//        dataSet.color = Color.parseColor("#4ad929")
        dataSet.valueTextSize = 15f
        dataSet.setGradientColor(Color.parseColor("#41b727"), Color.parseColor("#4bdf2b"))
        dataSet.valueTextColor = Color.parseColor("#4ad929")
        val barData = BarData(dataSet)
        barData.barWidth = 0.4f
        barChart.data = barData
        barChart.invalidate()
    }


}