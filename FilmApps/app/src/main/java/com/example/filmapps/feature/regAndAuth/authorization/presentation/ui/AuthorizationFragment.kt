package com.example.filmapps.feature.regAndAuth.authorization.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.filmapps.ComponentManager
import com.example.filmapps.databinding.FragmentAuthBinding
import com.example.filmapps.feature.regAndAuth.authorization.presentation.viewModel.AuthorizationViewModel
import com.example.filmapps.feature.regAndAuth.presentation.model.Result

class AuthorizationFragment : Fragment() {

    private var _binding: FragmentAuthBinding? = null

    private val binding get() = _binding!!

    private val vm by viewModels<AuthorizationViewModel> {
        ComponentManager.getAuthorizationComponent().viewModelsFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenStarted {
            vm.mutableState.collect {
                when (it) {
                    is Result.Success -> vm.goToFilm()
                    is Result.Error -> Toast.makeText(activity, it.message, Toast.LENGTH_SHORT)
                        .show()
                    else -> {}
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAuth.setOnClickListener {
            vm.auth(
                binding.editTextLoginAuth.text.toString(),
                binding.editTextPassAuth.text.toString()
            )
        }
        binding.backToReg.setOnClickListener {
            vm.goToMain()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        ComponentManager.clearAuthorizationComponent()
        _binding = null
    }
}