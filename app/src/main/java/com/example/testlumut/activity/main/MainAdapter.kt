package com.example.testlumut.activity.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.repository.repository.remote.response.ResponseTodosItem
import com.example.testlumut.R
import com.example.testlumut.databinding.ItemDataBinding
import com.google.android.material.imageview.ShapeableImageView

class MainAdapter(private val list: ArrayList<ResponseTodosItem>)
    : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private lateinit var context: Context
    var onDetail: (item: ResponseTodosItem) -> Unit = {}

    class ViewHolder(val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemDataBinding.inflate(layoutInflater, parent, false)
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvTitle.text = item.title
        holder.itemView.setOnClickListener {
            onDetail(item)
        }
        cekStatus(holder.binding.icon, item.completed)
    }

    override fun getItemCount(): Int = list.size

    private fun cekStatus(icon: ShapeableImageView, isAdults: Boolean?) {
        when (isAdults){
            true -> icon.setImageResource(R.drawable.icon_complete)
            else -> icon.setImageResource(R.drawable.icon_pending)
        }
    }
}