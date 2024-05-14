package com.example.testlumut

import com.example.testlumut.activity.detail.DetailViewModel
import com.example.testlumut.activity.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}