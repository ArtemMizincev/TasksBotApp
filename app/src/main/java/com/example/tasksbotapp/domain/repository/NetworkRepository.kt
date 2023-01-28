package com.example.tasksbotapp.domain.repository

import com.example.tasksbotapp.presentation.asks_screen.AsksListAdapter


interface NetworkRepository {

    fun removeData()

    suspend fun getData(adapter: AsksListAdapter?)

}