package com.example.eroto.viewModel.notification

import androidx.lifecycle.LiveData
import com.example.eroto.models.Notification
import com.example.eroto.models.NotificationList

interface NotificationViewModel {
    fun getNotifications(): LiveData<List<Notification>>
    fun setAllRead()
}