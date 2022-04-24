package com.example.eroto.repository.notification

import androidx.lifecycle.LiveData
import com.example.eroto.models.Notification

object NotificationRepository {

    private var webClient = NotificationWebClient

    fun getNotifications(): LiveData<List<Notification>> {
        return webClient.getNotifications()
    }
}