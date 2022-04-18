package com.example.eroto.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.eroto.R
import com.example.eroto.framents.StockChartFragment
import com.example.eroto.framents.StockDetailsFragment
import com.example.eroto.framents.StockPostsFragment
import com.example.eroto.framents.StockResearchFragment
import com.example.eroto.helpers.Helper
import com.google.android.material.navigation.NavigationView

class MainMenuActivity : AppCompatActivity() {
    private lateinit var navigation: NavigationView
    private lateinit var exitButton: ImageView
    private lateinit var depositButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        navigation = findViewById(R.id.main_menu_navigation)
        exitButton = findViewById(R.id.main_menu_exit_button)
        depositButton = findViewById(R.id.deposit_funds_button)

        Helper.disableNavigationViewScrollbars(navigation)

        navigation.setNavigationItemSelectedListener(::navigationHandler)

        depositButton.setOnClickListener {
            var intent = Intent(this, DepositActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
        }

        exitButton.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.no_animation, R.anim.to_left_animation)
        }
    }

    private fun navigationHandler(menuItem: MenuItem): Boolean {
        var activity = when (menuItem.itemId) {
            R.id.main_menu_logout -> LoginActivity::class.java
            else -> MainActivity::class.java
        }

        var intent = Intent(this, activity)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP and Intent.FLAG_ACTIVITY_CLEAR_TASK and Intent.FLAG_ACTIVITY_NEW_TASK)
        finish()
        startActivity(intent)
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
        return true
    }
}