package com.test.reddittop.models

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("title")
    var title: String?,
    @SerializedName("author")
    var author: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("created")
    var created: String?,
    @SerializedName("num_comments")
    var num_comments: String?
)