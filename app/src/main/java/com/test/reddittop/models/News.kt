package com.test.reddittop.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class News (
    @SerializedName("data")
    @Expose
    val data: GlobalData? = null
)