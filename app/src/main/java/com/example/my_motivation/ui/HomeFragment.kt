package com.example.my_motivation.ui

import MainviewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.my_motivation.data.adapter.CategoryCardAdapter
import com.example.my_motivation.data.remote.Repository
import com.example.my_motivation.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    lateinit var binding: FragmentHomeBinding
      val viewModel: MainviewModel by activityViewModels()



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
        var cardList = viewModel.loadCategoryCards()
        categoryAdapter.update(cardList)
        binding.favlistbtn.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToFavoriteFragment()
            )
        }

    }
}