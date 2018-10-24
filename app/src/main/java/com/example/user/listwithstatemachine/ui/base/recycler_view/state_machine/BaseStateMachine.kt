package com.example.user.listwithstatemachine.ui.base.recycler_view.state_machine

class BaseStateMachine<T>(protected val requestWorker: () -> RequestWorker<List<T>>,
                          private val viewController: ViewController<T>) {

    private var currentState: State<T> = EmptyState()
    private var completable: Completable? = null

    private fun loadData() {
        completable = requestWorker.invoke()
                .load({ currentState.dataLoaded(it) }, { currentState.error(it) })
    }

    interface ViewController<T> {
        fun showData(show: Boolean, data: List<T>)
        fun showEmptyState(show: Boolean)
        fun showErrorState(error: Throwable)
    }

    interface State<T> {
        fun restart() {}
        fun refresh() {}
        fun release() {}
        fun error(error: Throwable) {}
        fun dataLoaded(data: List<T>) {}
    }

    fun refresh() {
        currentState.refresh()
    }

    protected inner class EmptyState : State<T> {
        override fun refresh() {
            currentState = ProgressState()
            viewController.showEmptyState(true)
            loadData()
        }

        override fun release() {
            completable?.complete()
            currentState = ReleaseState()
        }
    }

    protected inner class ProgressState : State<T> {
        override fun dataLoaded(data: List<T>) {
            viewController.showData(true, data)
        }

        override fun error(error: Throwable) {
            viewController.showEmptyState(false)
            viewController.showErrorState(error)
        }
    }

    protected inner class ReleaseState : State<T> {

    }

}