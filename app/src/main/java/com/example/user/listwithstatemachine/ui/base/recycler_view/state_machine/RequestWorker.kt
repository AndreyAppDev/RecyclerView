package com.example.user.listwithstatemachine.ui.base.recycler_view.state_machine

interface RequestWorker<T> {
    fun load(onNext: (T) -> Unit, onError: (Throwable) -> Unit): Completable
    fun release()
}