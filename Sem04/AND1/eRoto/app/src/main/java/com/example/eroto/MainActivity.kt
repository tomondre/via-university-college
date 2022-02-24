package com.example.eroto

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var burgerButton: ImageButton
    private lateinit var bottomNavigation: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)

        burgerButton = findViewById(R.id.burgir)
        bottomNavigation = findViewById(R.id.bottom_navigation)

        bottomNavigation.setOnItemSelectedListener(::NavigationListener)
    }

    private fun NavigationListener(menuItem: MenuItem): Boolean {
        var fragment: Fragment = when(menuItem.itemId){
            R.id.discover_menu_item ->
                DiscoverFragment()
            else ->
                Main_fragment()
        }

        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, fragment)
        transaction.commit()

        return true
    }
}