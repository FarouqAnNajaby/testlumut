package com.example.testlumut.activity.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.repository.repository.remote.Resource
import com.example.testlumut.R
import com.example.testlumut.activity.main.MainViewModel
import com.example.testlumut.databinding.ActivityDetailBinding
import com.example.testlumut.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel by viewModel<DetailViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getIntExtra("id",0)

        viewModel.getData(id).observe(this){
            binding.loading.isVisible = it is Resource.Loading
            if (it is Resource.Success){
                binding.id.text = it.data.id.toString()
                binding.userId.text = it.data.userId.toString()
                binding.title.text = it.data.title.toString()
                if (it.data.completed == true){
                    binding.status.text = "Complete"
                }else {
                    binding.status.text = "not complete"
                }
            }else if (it is Resource.Error){
                Toast.makeText(this, "Data kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}