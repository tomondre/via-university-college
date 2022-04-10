package com.example.eroto.repository.notification

import androidx.lifecycle.LiveData
import com.example.eroto.models.Notification
import com.example.eroto.models.NotificationList

interface NotificationRepository {
    fun getNotifications(): LiveData<List<Notification>>
}