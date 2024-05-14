package com.example.testlumut.activity.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.repository.repository.TodosRepository

class MainViewModel (
    private val todosRepository: TodosRepository,
) : ViewModel(){

    fun getListTodos() = todosRepository.getListTodos().asLiveData()
}