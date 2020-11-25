package com.test.reddittop.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Child (
    @SerializedName("data")
    @Expose
    val childData: ChildData? = null
)