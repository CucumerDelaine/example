package com.example.filmapps.feature.characterList.presentation.ui

import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmapps.feature.characterList.presentation.viewModel.CharacterListViewModel


class PaginationScrollListener(
    private val vm: CharacterListViewModel,
    private val status: Boolean,
    private val progressBar: ProgressBar,
    private var page: Int
) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (dy > 0) {
            val layoutManager = recyclerView.layoutManager as GridLayoutManager
            val visibleItemCount = layoutManager.findLastCompletelyVisibleItemPosition() + 1
            if (visibleItemCount == layoutManager.itemCount && status) {
                page++
                vm.loadCharacterList(true)
                progressBar.visibility = ProgressBar.VISIBLE
            }
        }
    }
}