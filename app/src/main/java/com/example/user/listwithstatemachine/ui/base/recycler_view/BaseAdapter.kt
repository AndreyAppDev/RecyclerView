package com.example.user.listwithstatemachine.ui.base.recycler_view

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

abstract class BaseAdapter<T, ViewHolder : BaseViewHolder<T>>(private val dataList: MutableList<T> = mutableListOf()) : RecyclerView.Adapter<ViewHolder>() {

    abstract override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) = holder.bind(dataList[pos])

    override fun getItemCount() = dataList.size

    fun addData(data: T) {
        dataList.add(data)
        notifyItemInserted(dataList.size - 1)
    }

    fun addData(data: List<T>){
        dataList.addAll(data)
        notifyDataSetChanged()
    }

}