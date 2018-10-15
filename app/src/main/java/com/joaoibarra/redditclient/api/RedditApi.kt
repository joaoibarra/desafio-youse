package com.joaoibarra.gitapp.api

import com.joaoibarra.redditclient.api.models.PostListResponse
import io.reactivex.Observable
import retrofit2.http.*

public interface RedditApi {
    /*@Headers(
            "Accept: application/vnd.github.v3.text-match+json",
            "Content-type:application/json"
    )*/
    @GET("r/Android/new/.json")
    fun getPosts(@Query("after") after: String = "") : Observable<PostListResponse>
}