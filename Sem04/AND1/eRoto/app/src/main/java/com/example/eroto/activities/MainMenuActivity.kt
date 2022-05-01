package com.example.eroto.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.eroto.R
import com.example.eroto.helpers.Helper
import com.example.eroto.viewModel.mainMenu.MainMenuViewModel
import com.example.eroto.viewModel.mainMenu.MainMenuViewModelImpl
import com.google.android.material.navigation.NavigationView

class MainMenuActivity : AppCompatActivity() {
    private lateinit var navigation: NavigationView
    private lateinit var exitButton: ImageView
    private lateinit var depositButton: Button
    private lateinit var viewModel: MainMenuViewModel
    private lateinit var userImage: ImageView
    private lateinit var userName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        viewModel = ViewModelProvider(this).get(MainMenuViewModelImpl::class.java)

        bindViews()
        createObservers()
        createListeners()
        Helper.disableNavigationViewScrollbars(navigation)
    }

    private fun bindViews() {
        userName = findViewById(R.id.logged_user_name)
        userImage = findViewById(R.id.logged_in_image)
        navigation = findViewById(R.id.main_menu_navigation)
        exitButton = findViewById(R.id.main_menu_exit_button)
        depositButton = findViewById(R.id.deposit_funds_button)
    }

    private fun createObservers() {
        viewModel.getLoggedInUser().observe(this) {
            userName.text = it.name
        }
    }

    private fun createListeners() {
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