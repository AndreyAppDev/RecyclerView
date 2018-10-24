package com.example.user.listwithstatemachine.ui.news.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.widget.Toast
import com.example.user.listwithstatemachine.R
import com.example.user.listwithstatemachine.entity.News
import com.example.user.listwithstatemachine.ui.base.visible
import com.example.user.listwithstatemachine.ui.news.presenter.INewsPresenter
import com.example.user.listwithstatemachine.ui.news.presenter.NewsPresenter
import com.example.user.listwithstatemachine.ui.news.view.adapter.NewsRecyclerAdapter
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity(), INewsView {

    private lateinit var newsPresenter: INewsPresenter
    private lateinit var newsRecyclerAdapter: NewsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        newsPresenter = NewsPresenter()
        newsPresenter.bindView(this)
        initRecyclerView()
        loadNewsBtn.setOnClickListener { newsPresenter.loadNews() }
    }

    private fun initRecyclerView() {
        newsRecyclerAdapter = NewsRecyclerAdapter(LayoutInflater.from(this))
        newsRecyclerView.layoutManager = LinearLayoutManager(this)
        newsRecyclerView.adapter = newsRecyclerAdapter
    }

    override fun showNews(show: Boolean, data: List<News>) {
        newsRecyclerAdapter.addData(data)
        newsRecyclerView.visible(show)
        progressBanner.visible(!show)
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showError(msg: String) {
        showToast(msg)
    }

    override fun showEmptyProgress(show: Boolean) {
        loadNewsBtn.visible(!show)
        progressBanner.visible(show)
    }

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, NewsActivity::class.java)
            activity.startActivity(intent)
        }
    }

}