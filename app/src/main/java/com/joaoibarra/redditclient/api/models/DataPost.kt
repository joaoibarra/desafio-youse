package com.joaoibarra.redditclient.api.models

import com.google.gson.annotations.SerializedName

class DataPost (
        @SerializedName("modhash") val modhash: String,
        @SerializedName("dist") val dist: Int,
        @SerializedName("children") val posts: List<Post>,
        @SerializedName("after") val after: String,
        @SerializedName("before") val before: String
)