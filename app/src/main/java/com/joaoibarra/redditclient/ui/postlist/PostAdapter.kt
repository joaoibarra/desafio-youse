package com.joaoibarra.redditclient.ui.postlist

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.joaoibarra.gitapp.extensions.loadCircle
import com.joaoibarra.redditclient.R
import com.joaoibarra.redditclient.api.models.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(val listener: (Post?) -> Unit) : PagedListAdapter<Post, PostAdapter.ItemViewHolder>(itemDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(post: Post?, listener: (Post?) -> Unit) = with(itemView) {
            tvName.text = post?.postBody?.subredditNamePrefixed
            tvTitle.text = post?.postBody?.title
            tvUpDownCount.text = post?.postBody?.ups
            tvCommentCount.text = post?.postBody?.numComments
            tvAuthor.text = post?.postBody?.author
            ivThumbnail.loadCircle(post?.postBody?.thumbnail)
            setOnClickListener { listener(post) }
        }
    }

    companion object {
        val itemDiff = object: DiffUtil.ItemCallback<Post>() {

            override fun areItemsTheSame(old: Post, new: Post): Boolean {
                return old.postBody.createdUtc == new.postBody.createdUtc
            }

            override fun areContentsTheSame(old: Post, new: Post): Boolean {
                return old == new
            }

        }
    }
}