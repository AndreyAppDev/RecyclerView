package com.example.user.listwithstatemachine.ui.base.recycler_view.state_machine

interface State<T> {
    fun restart() {}
    fun refresh() {}
    fun release() {}
    fun error(error: Throwable) {}
    fun dataLoaded(data: List<T>) {}
}