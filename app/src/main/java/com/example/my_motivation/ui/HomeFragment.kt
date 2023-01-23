package com.example.my_motivation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.my_motivation.R
import com.example.my_motivation.data.adapter.CategoryCardAdapter
import com.example.my_motivation.data.remote.Repository
import com.example.my_motivation.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    lateinit var binding: FragmentHomeBinding
      //val viewModel: MainviewModel by viewModels()
        var repository = Repository()


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
        val categoryAdapter = CategoryCardAdapter()
        recyclerView.adapter = categoryAdapter
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.homeRecycler)
        var cardList = repository.loadcategorycard()
        categoryAdapter.update(cardList)

    }
}