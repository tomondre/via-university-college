package com.example.eroto.repository.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.eroto.models.Post
import com.example.eroto.models.PostUser

object PostWebClient {
    fun getStockPosts(ticker: String): LiveData<List<Post>> {
        var posts = MutableLiveData<List<Post>>(ArrayList())
        var list = ArrayList<Post>()

        for (i in 0..5) {
            list.add(
                Post(
                    PostUser(
                        "Sktbrd",
                        "Denmark",
                        "https://static.remove.bg/remove-bg-web/59c96072ccf69a79c0e6dd85a2eac05ceb4d0784/assets/start_remove-c851bdf8d3127a24e2d137a55b1b427378cd17385b01aec6e59d5d4b5f39d2ec.png"
                    ),
                    "3 minutes ago",
                    "In order to have a complete sentence, the sentence must have a minimum of three word types: a subject, a verb, and an object. In most cases, the subject is a noun or a pronoun. For example, the sentence &quot;Jack loves candy&quot; is a complete sentence because it has all three elements needed to make a complete sentence. Jack (the subject) loves (the verb) candy (the object).",
                    3,
                    5
                )
            )
        }

        posts.value = list
        return posts
    }

    fun getMainPosts(): LiveData<List<Post>> {
        var list = ArrayList<Post>()
        for (i in 0..5) {
            list.add(
                Post(
                    PostUser(
                        "Sktbrd",
                        "Denmark",
                        "https://static.remove.bg/remove-bg-web/59c96072ccf69a79c0e6dd85a2eac05ceb4d0784/assets/start_remove-c851bdf8d3127a24e2d137a55b1b427378cd17385b01aec6e59d5d4b5f39d2ec.png"
                    ),
                    "3 minutes ago",
                    "In order to have a complete sentence, the sentence must have a minimum of three word types: a subject, a verb, and an object. In most cases, the subject is a noun or a pronoun. For example, the sentence &quot;Jack loves candy&quot; is a complete sentence because it has all three elements needed to make a complete sentence. Jack (the subject) loves (the verb) candy (the object).",
                    3,
                    5
                )
            )
        }
        return MutableLiveData(list)
    }
}