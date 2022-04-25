package com.example.eroto.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.eroto.R
import com.example.eroto.framents.DiscoverFragment
import com.example.eroto.framents.MainFragment
import com.example.eroto.framents.PortfolioFragment
import com.example.eroto.framents.WatchlistFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var burgerButton: ImageButton
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var notificationButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)

        bindViews()
        createObservers()
        createListeners()
    }

    private fun bindViews() {
        burgerButton = findViewById(R.id.burgir)
        notificationButton = findViewById(R.id.main_screen_notification_button)
        bottomNavigation = findViewById(R.id.bottom_navigation)
    }

    private fun createObservers() {

    }

    private fun createListeners() {
        burgerButton.setOnClickListener {
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_left_animation, R.anim.no_animation)
        }
        notificationButton.setOnClickListener {
            val intent = Intent(this, Notifications::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.from_right_animation, R.anim.no_animation)
        }
        bottomNavigation.setOnItemSelectedListener(::navigationListener)
    }


    private fun navigationListener(menuItem: MenuItem): Boolean {
        var fragment: Fragment = when (menuItem.itemId) {
            R.id.discover_menu_item ->
                DiscoverFragment()
            R.id.portfolio_menu_item ->
                PortfolioFragment()
            R.id.watchlist_menu_item ->
                WatchlistFragment()
            else ->
                MainFragment()
        }

        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, fragment)
        transaction.commit()

        return true
    }
}