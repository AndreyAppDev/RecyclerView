package com.example.user.listwithstatemachine.ui.news.presenter

import com.example.user.listwithstatemachine.entity.News
import com.example.user.listwithstatemachine.ui.base.recycler_view.state_machine.BaseStateMachine
import com.example.user.listwithstatemachine.ui.base.recycler_view.state_machine.BaseViewState
import com.example.user.listwithstatemachine.ui.news.presenter.sm.LoadNewsWorker
import com.example.user.listwithstatemachine.ui.news.view.INewsView

class NewsPresenter : INewsPresenter {

    private var newsView: INewsView? = null
    private val loadNewsWorker = LoadNewsWorker()
    private val baseStateMachine: BaseStateMachine<News>

    init {
        baseStateMachine = BaseStateMachine({ loadNewsWorker },
                object : BaseViewState<News> {
                    override fun showErrorState(error: Throwable) {
                        newsView?.apply {
                            showError("Smth with wrong :(")
                        }
                    }

                    override fun showData(show: Boolean, data: List<News>) {
                        newsView?.showNews(show, data)
                    }

                    override fun showEmptyState(show: Boolean) {
                        newsView?.apply {
                            showEmptyProgress(show)
                        }
                    }
                })
    }

    override fun loadNews() {
        baseStateMachine.refresh()
    }

    override fun bindView(view: INewsView) {
        newsView = view
    }

    override fun unbind() {
        baseStateMachine.release()
        newsView = null
    }
}