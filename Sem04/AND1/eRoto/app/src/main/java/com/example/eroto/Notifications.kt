package com.example.eroto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eroto.adapters.NotificationAdapter
import com.example.eroto.viewModel.notification.NotificationViewModel
import com.example.eroto.viewModel.notification.NotificationViewModelImpl

class Notifications : AppCompatActivity() {
    private lateinit var notificationRecyclerView: RecyclerView
    private lateinit var backButton: ImageView

    private lateinit var viewModel: NotificationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        viewModel = ViewModelProvider(this).get(NotificationViewModelImpl::class.java)

        notificationRecyclerView = findViewById(R.id.notification_recycler_view)
        backButton = findViewById(R.id.notifications_back_button)
        backButton.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.no_animation, R.anim.to_right_animation)
        }

        createNotificationRecyclerView()
    }

    private fun createNotificationRecyclerView() {
        val notifications = viewModel.getNotifications()
        val notificationAdapter = NotificationAdapter(notifications.list)
        notificationRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        notificationRecyclerView.adapter = notificationAdapter
    }
}