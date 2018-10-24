package com.example.user.listwithstatemachine.ui.news.presenter

import com.example.user.listwithstatemachine.ui.news.view.INewsView

class NewsPresenter : INewsPresenter {
    override fun loadNews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var newsView: INewsView? = null

    override fun bindView(view: INewsView) {
        newsView = view
    }

    override fun unbind() {
        newsView = null
    }
}