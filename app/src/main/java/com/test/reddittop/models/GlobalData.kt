package com.test.reddittop.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class GlobalData (
    @SerializedName("children")
    @Expose
    val children: List<Child>? = null
)