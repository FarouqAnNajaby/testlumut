package com.example.repository.repository.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseTodos(

	@field:SerializedName("ResponseTodos")
	val responseTodos: List<ResponseTodosItem?>? = null
)

data class ResponseTodosItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("completed")
	val completed: Boolean? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
)
