package com.test.reddittop.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class News (
    @SerializedName("children")
    @Expose
    val data: List<Child>? = null
)