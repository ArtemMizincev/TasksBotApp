package com.example.tasksbotapp.domain.use_cases

import com.example.tasksbotapp.domain.repository.NetworkRepository

class RemoveAsks(val repository: NetworkRepository) {
    fun execute(){
        repository.removeData()
    }
}