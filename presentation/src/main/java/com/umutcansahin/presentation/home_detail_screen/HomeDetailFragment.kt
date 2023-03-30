package com.umutcansahin.presentation.home_detail_screen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umutcansahin.presentation.R

class HomeDetailFragment : Fragment() {

    companion object {
        fun newInstance() = HomeDetailFragment()
    }

    private lateinit var viewModel: HomeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}