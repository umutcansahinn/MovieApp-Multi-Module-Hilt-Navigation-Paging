package com.umutcansahin.presentation.search_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.umutcansahin.common.observeTextChanges
import com.umutcansahin.presentation.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<SearchViewModel>()
    private val searchAdapter = SearchAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }


    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    private fun initView() {
        binding.recyclerView.adapter = searchAdapter

        binding.etSearch.observeTextChanges()
            .filterNot { it.isBlank() }
            .debounce(300L)
            .distinctUntilChanged()
            .onEach {
                viewModel.searchMovie(it)
            }.launchIn(lifecycleScope)
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.searchMovie
                .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
                .collect {
                    when (it) {
                        is SearchUiState.Error -> {}
                        is SearchUiState.Loading -> {}
                        is SearchUiState.Success -> {
                            searchAdapter.submitData(it.data)
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