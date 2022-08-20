package com.example.filmapps.feature.characterList.presentation.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.filmapps.ComponentManager
import com.example.filmapps.databinding.FragmentCharacterListListBinding
import com.example.filmapps.feature.characterList.presentation.model.CharacterListResult
import com.example.filmapps.feature.characterList.presentation.viewModel.CharacterListViewModel
import com.example.filmapps.feature.characterListAndDetails.data.model.Character


class CharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListListBinding? = null

    private val binding get() = _binding!!

    private val vm by viewModels<CharacterListViewModel> {
        ComponentManager.getCharacterListComponent().viewModelsFactory()
    }

    private var status: Boolean = true
    private var page: Int = 1
    private val stateClickListener: CharacterListRecycleViewAdapter.OnCharacterClickListener =
        object :
            CharacterListRecycleViewAdapter.OnCharacterClickListener {
            override fun onCharacterClick(character: Character, position: Int) {
                vm.goToDetails(character)
            }
        }
    private var adapter = CharacterListRecycleViewAdapter(stateClickListener)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCharacterListListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.list
        val progressBar: ProgressBar = binding.progressBarCharacterList
        val swipeRefresh: SwipeRefreshLayout = binding.swipeRefresh
        recyclerView.adapter = adapter
        vm.pageNull()
        lifecycleScope.launchWhenStarted {
            vm.mutableState.collect {
                when (it) {
                    is CharacterListResult.Success -> {
                        adapter.setData(it.value)
                        progressBar.visibility = ProgressBar.INVISIBLE
                    }
                    is CharacterListResult.Error -> Log.d(TAG, it.message.toString())
                    is CharacterListResult.Loading -> progressBar.visibility = ProgressBar.VISIBLE
                    is CharacterListResult.Finally -> {
                        status = false
                        progressBar.visibility = ProgressBar.INVISIBLE
                    }
                }
            }
        }
        recyclerView.addOnScrollListener(PaginationScrollListener(vm, status, progressBar, page))
        swipeRefresh.setOnRefreshListener(OnRefreshListener {
            swipeRefresh.isRefreshing = false
            vm.clearDatabase()
            vm.pageNull()
            vm.loadCharacterList(true)
        })
        vm.loadCharacterList(true)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        ComponentManager.clearCharacterListComponent()
        _binding = null
    }

}