package com.umutcansahin.presentation.home_detail_screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.umutcansahin.data.response.single_movie.SingleMovieResponse
import com.umutcansahin.presentation.databinding.FragmentHomeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeDetailFragment : Fragment() {

    private var _binding: FragmentHomeDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeDetailViewModel>()
    private val args: HomeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.singleMovie
                .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
                .collect {
                    when(it) {
                        is HomeDetailUiState.Error -> {}
                        is HomeDetailUiState.Loading -> {}
                        is HomeDetailUiState.Success -> {
                            homeDetailFragmentUI(it.data)
                        }
                    }
                }
        }
    }

    private fun initView() {
        val movieId = args.id
        viewModel.getMovieById(movieId = movieId)
    }

    @SuppressLint("SetTextI18n")
    private fun homeDetailFragmentUI(response: SingleMovieResponse) {
        with(binding) {
            tvMovieTitle.text = response.title
            tvMovieBudget.text = "${response.budget}$"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}