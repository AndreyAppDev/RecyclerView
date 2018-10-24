package com.example.user.listwithstatemachine.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.user.listwithstatemachine.R
import com.example.user.listwithstatemachine.ui.news.view.NewsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newsActionBtn.setOnClickListener { NewsActivity.start(this) }
    }

}
