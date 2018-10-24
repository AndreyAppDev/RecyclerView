package com.example.user.listwithstatemachine.ui.news.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.user.listwithstatemachine.R
import com.example.user.listwithstatemachine.entity.News
import com.example.user.listwithstatemachine.ui.base.recycler_view.BaseAdapter

class NewsRecyclerAdapter(private val layoutInflater: LayoutInflater): BaseAdapter<News, NewsViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NewsViewHolder{
        val view = layoutInflater.inflate(R.layout.news_list_item, p0, false)
        return NewsViewHolder(view)
    }
}