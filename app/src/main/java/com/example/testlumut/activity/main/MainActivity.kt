package com.example.testlumut.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.repository.repository.remote.Resource
import com.example.repository.repository.remote.response.ResponseTodosItem
import com.example.testlumut.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainViewModel>()
    private val movieList = ArrayList<ResponseTodosItem>()
    private val adapter = MainAdapter(movieList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getListTodos().observe(this){
            binding.loading.isVisible = it is Resource.Loading
            if (it is Resource.Success){
                showData(it.data)
            }else if (it is Resource.Error){
                Toast.makeText(this, "Data kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showData(data : List<ResponseTodosItem?>?){
        if (data != null) {
            if(data.isNotEmpty()) {
                data.forEach {
                    movieList.add(it!!)
                    binding.rvData.layoutManager = GridLayoutManager(this,2)
                    binding.rvData.adapter = adapter
                    adapter.onDetail = {
        //            val intent = Intent(this@MainActivity, DetailActivity::class.java)
        //            intent.putExtra(Extra.DATA, it.id)
        //            startActivity(intent)
                    }
                }
            }
        }

    }

}