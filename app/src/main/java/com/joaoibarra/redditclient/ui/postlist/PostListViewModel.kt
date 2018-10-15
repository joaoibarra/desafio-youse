package com.joaoibarra.redditclient.ui.postlist

import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import android.arch.paging.RxPagedListBuilder
import com.joaoibarra.gitapp.api.RedditApiService
import com.joaoibarra.gitapp.api.paging.PostDatasourceFactory
import com.joaoibarra.redditclient.api.models.Post
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PostListViewModel : ViewModel() {

    var posts: Observable<PagedList<Post>>

    val compositeDisposable = CompositeDisposable()

    val postFactory: PostDatasourceFactory

    val pageSize = 30

    init {
        postFactory = PostDatasourceFactory(compositeDisposable, RedditApiService.create())

        val config = PagedList.Config.Builder()
                .setPageSize(pageSize)
                .setInitialLoadSizeHint(pageSize)
                .setPrefetchDistance(10)
                .setEnablePlaceholders(false)
                .build()

        posts = RxPagedListBuilder(postFactory, config)
                .setFetchScheduler(Schedulers.io())
                .buildObservable()
                .cache()

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
