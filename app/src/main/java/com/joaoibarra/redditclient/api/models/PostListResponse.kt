package com.joaoibarra.redditclient.api.models

import com.google.gson.annotations.SerializedName

class PostListResponse (
        @SerializedName("kind") val kind: String,
        @SerializedName("data") val dataPost: DataPost
)