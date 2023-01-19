package com.example.my_motivation.ui

import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.my_motivation.data.adapter.Categorycardadapter
import com.example.my_motivation.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    lateinit var binding: FragmentHomeBinding
    val viewModel: MainviewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.homeRecycler
        val categoryAdapter = Categorycardadapter()
        viewModel.memes.observe(viewLifecycleOwner) {
        //todo    Categorycardadapter.update(it)
        }
        recyclerView.adapter = categoryAdapter

    }


}