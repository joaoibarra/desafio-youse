package com.joaoibarra.redditclient.api.models

import com.google.gson.annotations.SerializedName

class Post (
        @SerializedName("kind") val kind: String,
        @SerializedName("data") val postBody: PostBody
)