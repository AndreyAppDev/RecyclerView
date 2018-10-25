package com.example.user.listwithstatemachine.ui.base.recycler_view.state_machine

interface BaseViewState<T> {
    fun showData(show: Boolean, data: List<T>)
    fun showEmptyState(show: Boolean)
    fun showErrorState(error: Throwable)
}
