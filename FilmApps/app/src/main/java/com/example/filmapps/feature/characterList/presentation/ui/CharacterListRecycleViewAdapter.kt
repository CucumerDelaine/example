package com.example.filmapps.feature.characterList.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.filmapps.databinding.FragmentCharacterListBinding
import com.example.filmapps.feature.characterListAndDetails.data.model.Character


class CharacterListRecycleViewAdapter(private val onClickListener: OnCharacterClickListener) :
    RecyclerView.Adapter<CharacterListRecycleViewAdapter.ViewHolder>() {

    private val values: MutableList<Character?>? =
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
        val item = values?.get(position)
        holder.idView.load(item?.image)

        holder.itemView.setOnClickListener {
            if (item != null) {
                onClickListener.onCharacterClick(item, position)
            }
        }
    }

    override fun getItemCount(): Int {
        return values?.size ?: 0
    }

    fun setData(characterUIModelList: List<Character?>?) {
        values?.clear()
        if (characterUIModelList != null) {
            values?.addAll(characterUIModelList)
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(binding: FragmentCharacterListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: ImageView = binding.image
    }

    interface OnCharacterClickListener {
        fun onCharacterClick(character: Character, position: Int)
    }
}
