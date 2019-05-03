package com.example.user.listwithstatemachine.ui.news.presenter.sm

import com.example.user.listwithstatemachine.data.NewsDataProvider
import com.example.user.listwithstatemachine.entity.News
import com.example.user.listwithstatemachine.ui.base.recycler_view.state_machine.Completable
import com.example.user.listwithstatemachine.ui.base.recycler_view.state_machine.RequestWorker
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LoadNewsWorker : RequestWorker<List<News>> {

    private val newsCompletable = NewsCompletable()
    private lateinit var disposable: Disposable
    private val dataProvider = NewsDataProvider()

    override fun load(onNext: (List<News>) -> Unit, onError: (Throwable) -> Unit): Completable {
        disposable = Single.fromCallable {
            Thread.sleep(5000)
        }.flatMap { Single.just(dataProvider.provide()) }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError)
        return newsCompletable
    }

    override fun release() {
        newsCompletable.complete()
    }

    inner class NewsCompletable : Completable {
        override fun complete() {
            disposable.dispose()
        }

        override fun error() {
            disposable.dispose()
        }
    }

}