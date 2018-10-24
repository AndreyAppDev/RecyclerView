package com.example.user.listwithstatemachine.ui.news.presenter

import com.example.user.listwithstatemachine.ui.news.view.INewsView

interface INewsPresenter {
    fun bindView(view: INewsView)
    fun unbind()
    fun loadNews()
}