package com.example.eroto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.eroto.helpers.Helper
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationBarMenu
import com.google.android.material.navigation.NavigationView

class MainMenu : AppCompatActivity() {
    private lateinit var navigation: NavigationView
    private lateinit var exitButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        navigation = findViewById(R.id.main_menu_navigation)
        exitButton = findViewById(R.id.main_menu_exit_button)

        Helper.disableNavigationViewScrollbars(navigation)

        exitButton.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.no_animation, R.anim.to_left_animation)
        }
    }
}