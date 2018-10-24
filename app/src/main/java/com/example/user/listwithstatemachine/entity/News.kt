package com.example.user.listwithstatemachine.entity

import java.text.SimpleDateFormat
import java.util.*

data class News(
    val title: String,
    val content: String,
    val publishDate: Date
) {
    val publishDateFormatted: String
        get() = simpleDateFormat.format(publishDate)

    companion object {
        val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.US)
    }
}