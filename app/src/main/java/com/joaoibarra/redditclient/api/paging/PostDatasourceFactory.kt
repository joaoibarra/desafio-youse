package com.joaoibarra.gitapp.api.paging

import android.arch.paging.DataSource
import com.joaoibarra.gitapp.api.RedditApi
import com.joaoibarra.redditclient.api.models.Post
import io.reactivex.disposables.CompositeDisposable

class PostDatasourceFactory (
    private val compositeDisposable: CompositeDisposable,
    private val redditApi: RedditApi
): DataSource.Factory<Long, Post>() {

    override fun create(): DataSource<Long, Post> {
        return PostDataSource(redditApi, compositeDisposable)
    }
}