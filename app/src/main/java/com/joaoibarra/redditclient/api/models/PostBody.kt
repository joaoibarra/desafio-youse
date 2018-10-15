package com.joaoibarra.redditclient.api.models

import com.google.gson.annotations.SerializedName

class PostBody (
        @SerializedName("approved_at_utc") val approvedAtUtc: String,
        @SerializedName("subreddit") val subreddit: String,
        @SerializedName("selftext") val selftext: String,
        @SerializedName("author_fullname") val authorFullname: String,
        @SerializedName("saved") val saved: Boolean,
        @SerializedName("mod_reason_title") val modReasonTitle: String,
        @SerializedName("gilded") val gilded: Int,
        @SerializedName("clicked") val clicked: Boolean,
        @SerializedName("title") val title: String,
        @SerializedName("subreddit_name_prefixed") val subredditNamePrefixed: String,
        @SerializedName("hidden") val hidden: Boolean,
        @SerializedName("pwls") val pwls: Int,
        @SerializedName("link_flair_css_class") val linkFlairCssClass: String,
        @SerializedName("downs") val downs: Int,
        @SerializedName("thumbnail_height") val thumbnailHeight: Int,
        @SerializedName("hide_score") val hideScore: Boolean,
        @SerializedName("name") val name: String,
        @SerializedName("quarantine") val quarantine: Boolean,
        @SerializedName("link_flair_text_color") val linkFlairTextColor: String,
        @SerializedName("author_flair_background_color") val authorFlairBackgroundColor: String,
        @SerializedName("subreddit_type") val subredditType: String,
        @SerializedName("ups") val ups: String,
        @SerializedName("domain") val domain: String,
        @SerializedName("thumbnail_width") val thumbnailWidth: Int,
        @SerializedName("author_flair_template_id") val authorFlairTemplate_id: String,
        @SerializedName("is_original_content") val isOriginalContent: Boolean,
        @SerializedName("is_reddit_media_domain") val isRedditMediaDomain: Boolean,
        @SerializedName("is_meta") val isMeta: Boolean,
        @SerializedName("category") val category: String,
        @SerializedName("link_flair_text") val linkFlairText: String,
        @SerializedName("can_mod_post") val canModPost: Boolean,
        @SerializedName("score") val score: Int,
        @SerializedName("thumbnail") val thumbnail: String,
        @SerializedName("author_flair_css_class") val authorFlairCssClass: String,
        @SerializedName("post_hint") val postHint: String,
        @SerializedName("content_categories") val contentCategories: String,
        @SerializedName("is_self") val isSelf: String,
        @SerializedName("created_utc") val createdUtc: Long,
        @SerializedName("url") val url: String,
        @SerializedName("author") val author: String,
        @SerializedName("num_comments") val numComments: String


)