package com.umutcansahin.presentation.home_screen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.umutcansahin.presentation.R
import com.umutcansahin.presentation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

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
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}