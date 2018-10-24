package com.example.user.listwithstatemachine.data

interface DataProvider<T> {
    fun provide(): MutableList<T>
}