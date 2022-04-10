package com.example.eroto.repository.notification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.eroto.models.Notification

object NotificationWebClient : NotificationRepository {
    override fun getNotifications(): LiveData<List<Notification>> {
        var list: ArrayList<Notification> = ArrayList()

        for (i in 0..5)
        {
            list.add(Notification("about 11 hours ago", "@JeppeKirkBonde wrote a post", false,"https://etoro-cdn.etorostatic.com/avatars/150X150/2988943/7.jpg"))
        }
        return MutableLiveData(list)
    }

}