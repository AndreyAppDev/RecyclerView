package com.example.user.listwithstatemachine.ui.news.view.adapter

import android.view.View
import com.example.user.listwithstatemachine.entity.News
import com.example.user.listwithstatemachine.ui.base.recycler_view.BaseViewHolder
import kotlinx.android.synthetic.main.news_list_item.*

class NewsViewHolder(itemView: View, dataList: MutableList<News> = mutableListOf()) : BaseViewHolder<News>(itemView, dataList, itemView) {
    override fun bind(data: News) {
        newsTitle.text = data.title
        newsContent.text = data.content
        newsPublishDate.text = data.publishDateFormatted
    }
}