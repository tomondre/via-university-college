package com.example.eroto.viewModel.notification

import com.example.eroto.models.NotificationList

interface NotificationViewModel {
    fun getNotifications(): NotificationList
}