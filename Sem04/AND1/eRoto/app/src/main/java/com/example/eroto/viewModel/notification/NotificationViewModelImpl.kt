package com.example.eroto.viewModel.notification

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.eroto.models.Notification
import com.example.eroto.repository.notification.NotificationRepositoryImpl

class NotificationViewModelImpl: ViewModel(), NotificationViewModel {

    private var notificationRepository= NotificationRepositoryImpl()

    override fun getNotifications(): LiveData<List<Notification>> {
        return notificationRepository.getNotifications()
    }

    override fun setAllRead() {

    }
}