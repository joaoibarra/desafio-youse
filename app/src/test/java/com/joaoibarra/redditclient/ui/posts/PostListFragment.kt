package com.joaoibarra.redditclient.ui.posts

import android.arch.paging.PagedList
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.joaoibarra.gitapp.api.paging.PostDatasourceFactory
import com.joaoibarra.redditclient.api.models.Post
import com.joaoibarra.redditclient.ui.postlist.PostListViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.ArgumentMatchers.any
import org.mockito.MockitoAnnotations
import org.mockito.Mockito




@Mockable
@RunWith(MockitoJUnitRunner::class)
class PostListFragment {

    @Mock
    lateinit var layoutInflater: LayoutInflater

    @Mock
    lateinit var view: View

    @Mock
    lateinit var recyclerPosts: RecyclerView

    @Mock
    lateinit var viewModel: PostListViewModel

    @Mock
    lateinit var postListFragment: PostListFragment

    @Mock
    lateinit var posts: Observable<PagedList<Post>>

    @Mock
    lateinit var postFactory: PostDatasourceFactory

    @Mock
    lateinit var compositeDisposable: CompositeDisposable

    @Before
    fun setup() {
        //MockitoAnnotations.initMocks(this)

        viewModel = Mockito.mock(PostListViewModel::class.java)

        Mockito.`when`(viewModel.posts).thenReturn(any())
        Mockito.`when`(viewModel.postFactory).thenReturn(postFactory)
        Mockito.`when`(viewModel.compositeDisposable).thenReturn(compositeDisposable)

        //postListFragment = PostListFragment()
    }

    @After
    fun validate() {
        Mockito.validateMockitoUsage()
    }

    @Test
    fun postAdapterOnClickListener() {
        Mockito.verify(recyclerPosts, Mockito.times(1)).adapter = any()
    }
}