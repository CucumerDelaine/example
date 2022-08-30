package com.example.filmapps.featureCharacterListAndDetails.featureCharacterList.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.core_db_api.model.Character
import com.example.filmapps.databinding.FragmentCharacterListBinding


class CharacterListRecycleViewAdapter(private val onClickListener: OnCharacterClickListener) :
    RecyclerView.Adapter<CharacterListRecycleViewAdapter.ViewHolder>() {

    private val values: MutableList<Character?> =
        mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentCharacterListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.load(item?.image)

        holder.itemView.setOnClickListener {
            if (item != null) {
                onClickListener.onCharacterClick(item, position)
            }
        }
    }

    override fun getItemCount(): Int {
        return values.size
    }

    fun setData(characterEntityUIModelList: List<Character?>) {
        values.clear()
        values.addAll(characterEntityUIModelList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(binding: FragmentCharacterListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: ImageView = binding.image
    }

    interface OnCharacterClickListener {
        fun onCharacterClick(characterEntity: Character, position: Int)
    }
}
