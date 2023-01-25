package com.example.tasksbotapp.domain.use_cases

import com.example.tasksbotapp.domain.repository.NetworkRepository
import com.example.tasksbotapp.presentation.main.AsksListAdapter

class GetAsks(val repository: NetworkRepository) {
    suspend fun execute(adapter: AsksListAdapter){
        repository.getData(adapter)
    }
}