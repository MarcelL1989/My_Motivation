package com.example.my_motivation.ui

import MainviewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.my_motivation.data.adapter.CategoryCardAdapter
import com.example.my_motivation.data.adapter.FavoriteAdapter
import com.example.my_motivation.databinding.FragmentFavoritenBinding
import com.example.my_motivation.databinding.FragmentHomeBinding

class FavoriteFragment: Fragment() {
    lateinit var binding: FragmentFavoritenBinding
    val viewModel: MainviewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var recycler= binding.favoritenRecycler
        var favoriteAdapter = viewModel.favoritesList.value?.let { FavoriteAdapter(it) }
        recycler.adapter = favoriteAdapter



        binding.backtomenubtn.setOnClickListener{
            findNavController().navigateUp()
        }
    }
}