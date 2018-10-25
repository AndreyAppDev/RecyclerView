package com.example.user.listwithstatemachine.ui.base

import android.view.View

fun View.visible(show: Boolean) {
    this.visibility = if (show) View.VISIBLE else View.GONE
}
