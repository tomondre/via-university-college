package com.example.eroto.viewModel.notification

import androidx.lifecycle.ViewModel
import com.example.eroto.models.Notification
import com.example.eroto.models.NotificationList

class NotificationViewModelImpl: ViewModel(), NotificationViewModel {
    override fun getNotifications(): NotificationList {
        var list: ArrayList<Notification> = ArrayList()

        for (i in 0..5)
        {
            list.add(Notification("about 11 hours ago", "@JeppeKirkBonde wrote a post", false,"https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.etoro.com%2Fpeople%2Fjeppekirkbonde&psig=AOvVaw28LdKToU9iIqh8bjXOnHET&ust=1646075277055000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKC3ibXKoPYCFQAAAAAdAAAAABAD"))
        }
        return NotificationList(list)
    }
}