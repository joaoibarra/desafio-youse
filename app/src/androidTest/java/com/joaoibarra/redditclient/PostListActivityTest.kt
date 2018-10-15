package com.joaoibarra.redditclient

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.joaoibarra.redditclient.ui.postlist.PostAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class PostListActivityTest {

    @JvmField
    @Rule
    val mPostListActivityTestRule = ActivityTestRule<PostListActivity>(PostListActivity::class.java)

    @Test
    fun onViewLoadedShowPostListFragment() {
        onView(withId(R.id.container)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerPosts)).check(matches(isDisplayed()))
        RecyclerViewActions.actionOnItemAtPosition<PostAdapter.ItemViewHolder>(0, click())
    }
    
}