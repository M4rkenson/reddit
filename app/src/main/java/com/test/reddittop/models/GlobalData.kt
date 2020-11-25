package com.test.reddittop.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class GlobalData (
    @SerializedName("data")
    @Expose
    val globalData: News? = null
)