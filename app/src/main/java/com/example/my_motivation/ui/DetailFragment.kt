package com.example.my_motivation.ui

import MainviewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.my_motivation.data.model.Detailcard
import com.example.my_motivation.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    lateinit var detailCard: Detailcard
    val viewModel: MainviewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadDetailCards()
        var detailId = requireArguments().getInt("categoryid")
        viewModel.detailCards.observe(viewLifecycleOwner) {
            detailCard = it.find { detailcard ->
                detailcard.id == detailId
            }!!
            if (detailCard != null) {
                binding.motivationalPicture.load(detailCard.bild)
                binding.Motivationsspruch.text = detailCard.spruch
            }
        }
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
        viewModel.favoritesList.observe(viewLifecycleOwner) {
            binding.favBtn.setOnClickListener {v->
                var favorites= it.find {
                    it.id==detailCard.id
                }
                if (favorites!=null) {
                    viewModel.deleteFavorites(detailCard)
                    Log.d("yooo",favorites.toString())

                }else{
                    viewModel.insertFavorites(detailCard)
                    Log.d("uuuuuu",favorites.toString())

                }
            }
        }

    }

}