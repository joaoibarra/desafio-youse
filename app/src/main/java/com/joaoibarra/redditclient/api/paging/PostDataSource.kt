package com.joaoibarra.gitapp.api.paging

import android.arch.paging.ItemKeyedDataSource
import android.util.Log
import com.joaoibarra.gitapp.api.RedditApi
import com.joaoibarra.redditclient.api.models.Post
import io.reactivex.disposables.CompositeDisposable

class PostDataSource (
        private val redditApi: RedditApi,
        private val compositeDisposable: CompositeDisposable
): ItemKeyedDataSource<Long, Post>(){
    private var after = ""
    private var before = ""

    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<Post>) {
        createObservable(after , callback, null)
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Post>) {
        createObservable(after, null, callback)
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Post>) {
        //Empty method
    }

    override fun getKey(item: Post): Long {
        return item.postBody.createdUtc
    }

    private fun createObservable(next: String,
                                 initialCallback: LoadInitialCallback<Post>?,
                                 callback: LoadCallback<Post>?) {
        compositeDisposable.add(
                redditApi.getPosts(next)
                .subscribe(
                    { response ->
                        initialCallback?.onResult(response.dataPost.posts)
                        callback?.onResult(response.dataPost.posts)
                        after = response.dataPost.after
                        before = response.dataPost.before
                    },
                    { t ->
                        Log.d("Error On Load", "Error loading page: $next", t)
                    }
                )
        )
    }
}