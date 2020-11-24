package com.test.reddittop.viewmodels

import androidx.lifecycle.*
import com.test.reddittop.network.ApiNews
import com.test.reddittop.network.Event
import com.test.reddittop.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


abstract class NewsViewModel : ViewModel() {
    var api: ApiNews = NetworkService.retrofitService()


    fun <News> requestWithLiveData(
        liveData: MutableLiveData<Event<List<News>>>,
        request: suspend () -> List<News>
    ) {
        liveData.postValue(Event.loading())
        this.viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = request.invoke()
                if (!response.isNullOrEmpty()) {
                    liveData.postValue(Event.success(response))

                } else {
                    liveData.postValue(Event.error(null))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                liveData.postValue(Event.error(null))
            }
        }
    }

}