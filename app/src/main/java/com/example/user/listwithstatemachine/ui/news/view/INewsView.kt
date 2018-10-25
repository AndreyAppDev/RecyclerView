package com.example.user.listwithstatemachine.ui.news.view

import com.example.user.listwithstatemachine.entity.News

interface INewsView {
    fun showNews(show: Boolean, data: List<News>)
    fun showError(msg: String)
    fun showToast(msg: String)
    fun showEmptyProgress(show: Boolean)
}