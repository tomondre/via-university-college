package com.example.eroto.viewModel.notification

import androidx.lifecycle.ViewModel
import com.example.eroto.models.Notification
import com.example.eroto.models.NotificationList

class NotificationViewModelImpl: ViewModel(), NotificationViewModel {
    override fun getNotifications(): NotificationList {
        var list: ArrayList<Notification> = ArrayList()

        for (i in 0..5)
        {
            list.add(Notification("about 11 hours ago", "@JeppeKirkBonde wrote a post", false,"https://etoro-cdn.etorostatic.com/avatars/150X150/2988943/7.jpg"))
        }
        return NotificationList(list)
    }
}