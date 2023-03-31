package com.umutcansahin.presentation.home_screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.umutcansahin.presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()
    private val movieAdapter = MovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }

    private fun initView() {
        /*  binding.tvTitle.setOnClickListener {
           findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToHomeDetailFragment())
           findNavController().navigate(com.umutcansahin.navigation.R.id.action_homeFragment_to_homeDetailFragment)
       }*/
        binding.recyclerView.adapter = movieAdapter

        movieAdapter.addLoadStateListener {combinedLoadStates->
            if (combinedLoadStates.refresh is LoadState.Loading) {
                Log.d("xxx","loading")
            }else {
                Log.d("xxx","not Loading")
            }
        }
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.popularMovie
                .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
                .collectLatest {
                    when (it) {
                        is HomeUiState.Error -> {}
                        is HomeUiState.Loading -> {}
                        is HomeUiState.Success -> {
                            movieAdapter.submitData(it.data)
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