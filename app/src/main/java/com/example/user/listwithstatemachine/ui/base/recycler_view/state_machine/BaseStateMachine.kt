package com.example.user.listwithstatemachine.ui.base.recycler_view.state_machine

class BaseStateMachine<T>(protected val requestWorker: () -> RequestWorker<List<T>>,
                          private val viewController: BaseViewState<T>) {

    private var currentState: State<T> = EmptyState()
    private var completable: Completable? = null

    private fun loadData() {
        completable = requestWorker.invoke()
                .load({ currentState.dataLoaded(it) }, { currentState.error(it) })
    }

    fun refresh() {
        currentState.refresh()
    }

    fun release(){
        currentState.release()
    }

    private inner class EmptyState : State<T> {
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

    private inner class ProgressState : State<T> {
        override fun dataLoaded(data: List<T>) {
            viewController.showData(true, data)
        }

        override fun error(error: Throwable) {
            viewController.showEmptyState(false)
            viewController.showErrorState(error)
        }

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

    private inner class ReleaseState : State<T>

}