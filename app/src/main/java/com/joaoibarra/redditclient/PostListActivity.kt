package com.joaoibarra.redditclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import com.joaoibarra.redditclient.ui.postlist.PostListFragment
import io.reactivex.android.schedulers.AndroidSchedulers

class PostListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.post_list_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, PostListFragment.newInstance())
                    .commitNow()
        }
    }

}
