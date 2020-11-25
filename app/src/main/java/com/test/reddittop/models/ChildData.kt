package com.test.reddittop.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ChildData (
    @SerializedName("title")
    @Expose
    val title: String? = null,

    @SerializedName("num_comments")
    @Expose
    val numComments: Int? = null,

    @SerializedName("created")
    @Expose
    val created: Int? = null,

    @SerializedName("author")
    @Expose
    val author: String? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null
)