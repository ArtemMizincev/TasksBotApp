package com.example.tasksbotapp.domain.repository

import com.example.tasksbotapp.presentation.main.AsksListAdapter


interface NetworkRepository {

    fun removeData()

    suspend fun getData(adapter: AsksListAdapter?)

}