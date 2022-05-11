package com.example.s09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var saveButton: Button
    private lateinit var workingDayAdapter: WorkingDayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        createListeners()
        createWorkingDaysRecycler()
    }

    private fun createWorkingDaysRecycler() {
        //ViewModel call
        val daysShortcuts = listOf("M", "T", "W", "T", "F", "S", "S")
        val workingWeek = WorkingWeek()
        workingWeek.days.forEachIndexed { index, day ->
            day.shortcut = daysShortcuts[index]
            day.morning = Random.nextBoolean()
            day.noon = Random.nextBoolean()
            day.afternoon = Random.nextBoolean()
        }

        workingDayAdapter = WorkingDayAdapter(workingWeek)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = workingDayAdapter
    }

    private fun bindViews() {
        recyclerView = findViewById(R.id.recyclerView)
        saveButton = findViewById(R.id.saveButton)
    }

    private fun createListeners() {
        saveButton.setOnClickListener {
            val workingWeek = workingDayAdapter.workingWeek
            println(workingWeek)
            //Save working week into database
        }
    }
}