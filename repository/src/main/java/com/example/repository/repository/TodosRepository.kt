package com.example.repository.repository

import com.example.repository.repository.remote.Resource
import com.example.repository.repository.remote.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TodosRepository (
    private val service: ApiService,
) {
    fun getListTodos() = flow {
        emit(Resource.Loading)
        try {
            val response = service.getListTodos()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)

    fun getDetailTodo(todoId: Int) = flow {
        emit(Resource.Loading)
        try {
            val response = service.getDetailTodo(todoId)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)

}