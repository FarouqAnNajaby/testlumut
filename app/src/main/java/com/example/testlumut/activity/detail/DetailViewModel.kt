package com.example.testlumut.activity.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.repository.repository.TodosRepository

class DetailViewModel (
    private val todosRepository: TodosRepository,
) : ViewModel(){

    fun getData(id: Int) = todosRepository.getDetailTodo(id).asLiveData()
}