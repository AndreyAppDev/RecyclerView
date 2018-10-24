package com.example.user.listwithstatemachine.ui.base.recycler_view

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<T>(view: View, private val dataList: List<T>, override val containerView: View) : RecyclerView.ViewHolder(view), LayoutContainer {

    abstract fun bind(data: T)

    fun getDataByPosition(pos: Int): T {
        return dataList[pos]
    }

}