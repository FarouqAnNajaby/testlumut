package com.example.repository.repository.remote.service

import com.example.repository.repository.remote.response.ResponseTodosItem
import retrofit2.http.*


interface ApiService {
    @GET("todos")
    suspend fun getListTodos() : List<ResponseTodosItem?>?

}