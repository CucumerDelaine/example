package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load

import com.example.myapplication.placeholder.PlaceholderContent.PlaceholderItem
import com.example.myapplication.databinding.FragmentItem2Binding


class MyItemRecyclerViewAdapter2(
    private val values: ArrayList<Results>?
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter2.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItem2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values?.get(position)
        holder.idImage.load(item?.image)
        holder.contentView.text = item?.name
    }

    override fun getItemCount(): Int {
        return values?.size ?: 1
    }

    inner class ViewHolder(binding: FragmentItem2Binding) : RecyclerView.ViewHolder(binding.root) {
        val idImage: ImageView = binding.imageView
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}