package com.umutcansahin.presentation.home_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.umutcansahin.presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvTitle.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToHomeDetailFragment())
          //  findNavController().navigate(com.umutcansahin.navigation.R.id.action_homeFragment_to_homeDetailFragment)
        }
        observeData()
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.popularMovie
                .flowWithLifecycle(viewLifecycleOwner.lifecycle,Lifecycle.State.STARTED)
                .collect {
                    when(it) {
                        is HomeUiState.Error-> {}
                        is HomeUiState.Loading-> {}
                        is HomeUiState.Success-> {
                            it.data?.let { response->
                                response.results?.forEach {result->
                                    binding.tvTitle.text = result.title
                                }
                            }
                        }
                    }
                }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}