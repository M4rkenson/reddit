package com.test.reddittop.viewmodels

import androidx.lifecycle.MutableLiveData
import com.test.reddittop.models.Child
import com.test.reddittop.models.GlobalData
import com.test.reddittop.models.News
import com.test.reddittop.network.Event

class ActivityViewModel : NewsViewModel() {
    val simpleLiveData = MutableLiveData<Event<List<GlobalData>>>()

    suspend fun getNews() {
        requestWithLiveData(simpleLiveData) {
            api.getTopNews()
        }
    }
}

