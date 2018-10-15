package com.joaoibarra.redditclient.ui.postlist

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.support.customtabs.CustomTabsIntent
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.joaoibarra.redditclient.R
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.post_list_fragment.*

class PostListFragment : Fragment() {

    private var recyclerState: Parcelable? = null

    private lateinit var viewModel: PostListViewModel

    companion object {
        fun newInstance() = PostListFragment()
    }

    private val adapter: PostAdapter by lazy {
        PostAdapter {

            val customTabsIntent = CustomTabsIntent.Builder().build()
            customTabsIntent.launchUrl(activity, Uri.parse(it!!.postBody.url))

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.post_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PostListViewModel::class.java)
        recyclerState = savedInstanceState

        val llm = LinearLayoutManager(activity)
        recyclerPosts.layoutManager = llm
        recyclerPosts.adapter = adapter
        subscribeToList()
    }

    private fun subscribeToList() {
        val disposable = viewModel.posts
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { list ->
                            adapter.submitList(list)
                            if (recyclerState != null) {
                                recyclerPosts.layoutManager?.onRestoreInstanceState(recyclerState)
                                recyclerState = null
                            }
                        },
                        { e ->
                            Log.e("Error OnLoad", "Error", e)
                        }
                )
    }

}
