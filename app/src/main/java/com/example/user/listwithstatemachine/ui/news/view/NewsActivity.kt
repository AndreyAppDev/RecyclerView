package com.example.user.listwithstatemachine.ui.news.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import com.example.user.listwithstatemachine.R
import com.example.user.listwithstatemachine.data.DataProvider
import com.example.user.listwithstatemachine.data.NewsDataProvider
import com.example.user.listwithstatemachine.entity.News
import com.example.user.listwithstatemachine.ui.news.presenter.INewsPresenter
import com.example.user.listwithstatemachine.ui.news.presenter.NewsPresenter
import com.example.user.listwithstatemachine.ui.news.view.adapter.NewsRecyclerAdapter
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity(), INewsView {

    private lateinit var newsPresenter: INewsPresenter
    private val newsDataProvider: DataProvider<News> = NewsDataProvider()
    private lateinit var newsRecyclerAdapter: NewsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        newsPresenter = NewsPresenter()
        newsPresenter.bindView(this)
        initRecyclerView()
        newsRecyclerAdapter.addData(newsDataProvider.provide())
    }

    private fun initRecyclerView(){
        newsRecyclerAdapter = NewsRecyclerAdapter(LayoutInflater.from(this))
        newsRecyclerView.layoutManager = LinearLayoutManager(this)
        newsRecyclerView.adapter = newsRecyclerAdapter
    }

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, NewsActivity::class.java)
            activity.startActivity(intent)
        }
    }

}