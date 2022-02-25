package com.example.eroto

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.eroto.framents.DiscoverFragment
import com.example.eroto.framents.MainFragment
import com.example.eroto.framents.PortfolioFragment
import com.example.eroto.framents.WatchlistFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var burgerButton: ImageButton
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)

        burgerButton = findViewById(R.id.burgir)
        bottomNavigation = findViewById(R.id.bottom_navigation)

        bottomNavigation.setOnItemSelectedListener(::navigationListener)
    }

    private fun navigationListener(menuItem: MenuItem): Boolean {
        var fragment: Fragment = when(menuItem.itemId){
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