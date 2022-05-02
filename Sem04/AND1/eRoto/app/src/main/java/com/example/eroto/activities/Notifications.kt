package com.example.eroto.activities

import android.app.Notification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eroto.R
import com.example.eroto.adapters.NotificationAdapter
import com.example.eroto.viewModel.notification.NotificationViewModel
import com.example.eroto.viewModel.notification.NotificationViewModelImpl

class Notifications : AppCompatActivity() {
    private lateinit var notificationRecyclerView: RecyclerView
    private lateinit var backButton: ImageView
    private var notificationAdapter: NotificationAdapter = NotificationAdapter()

    private lateinit var viewModel: NotificationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        viewModel = ViewModelProvider(this).get(NotificationViewModelImpl::class.java)

        bindViews()
        createObservers()
        createListeners()
        createNotificationRecyclerView()
    }

    private fun bindViews() {
        notificationRecyclerView = findViewById(R.id.notification_recycler_view)
        backButton = findViewById(R.id.notifications_back_button)
    }

    private fun createObservers() {
        viewModel.getNotifications().observe(this) {
            loadNotificationData(it)
        }
    }

    private fun createListeners() {
        backButton.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.no_animation, R.anim.to_right_animation)
        }
    }

    private fun loadNotificationData(list: List<com.example.eroto.models.Notification>) {
        notificationAdapter.list = list
    }

    private fun createNotificationRecyclerView() {
        notificationRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        notificationRecyclerView.adapter = notificationAdapter
    }

    private fun markAllAsRead() {
        viewModel.setAllRead()
    }
}