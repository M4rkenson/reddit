package com.test.reddittop

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Child {
    @SerializedName("data")
    @Expose
    val data: DataInfo? = null
}
class Data {
    @SerializedName("children")
    @Expose
    val children: List<Child>? = null
}

data class DataInfo (
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
class News {
    @SerializedName("data")
    @Expose
    val data: Data? = null
}