package com.example.my_motivation.ui

import MainviewModel
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.my_motivation.data.model.Detailcard
import com.example.my_motivation.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    lateinit var detailCard: Detailcard
    val viewModel: MainviewModel by activityViewModels()
    var unclickedColor = Color.TRANSPARENT
    var clickedColor = Color.YELLOW

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        if (viewModel.favButtonState) {
            binding.favBtn.setColorFilter(clickedColor)
        } else {
            binding.favBtn.setColorFilter(unclickedColor)
        }
        return binding.root
    }
    //override fun onResume() {
       // super.onResume()
       // binding.favBtn.colorFilter = PorterDuffColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN)
    ////}


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadDetailCards()
        var detailId = requireArguments().getInt("categoryid")
        viewModel.detailCards.observe(viewLifecycleOwner) {
            detailCard = it.find { detailcard ->
                detailcard.id == detailId
            }!!
            getCorrectFavBtnColor(detailCard)
            binding.motivationalPicture.load(detailCard.bild)
            binding.Motivationsspruch.text = detailCard.spruch

        }
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.favBtn.setOnClickListener {
            if (detailCard.state==false) {
                detailCard.state = true
                binding.favBtn.setColorFilter(clickedColor)
                viewModel.insertFavorites(detailCard)
            }else{
                detailCard.state = false
                binding.favBtn.setColorFilter(unclickedColor)
                viewModel.insertFavorites(detailCard)
            }
        }

        /*viewModel.favoritesList.observe(viewLifecycleOwner) {
            binding.favBtn.setOnClickListener {
                    v->
                var favorites= it.find {
                    it.id==detailCard.id
                }
                if (favorites!=null) {
                    viewModel.favButtonState = false
                    favorites.state = false
                    binding.favBtn.setColorFilter(unclickedColor)
                    viewModel.deleteFavorites(detailCard)
                    Log.d("yooo",favorites.toString())

                }else{
                    viewModel.favButtonState = true
                    favorites = detailCard.copy(state = true)
                    binding.favBtn.setColorFilter(clickedColor)
                    viewModel.insertFavorites(detailCard)
                    Log.d("uuuuuu",favorites.toString())
                }
            }
        }*/
    }
    private fun getCorrectFavBtnColor(detailcard: Detailcard) {
        if (detailcard.state == null){
            binding.favBtn.setColorFilter(unclickedColor)
        }
        else if (detailcard.state == true) {
            binding.favBtn.setColorFilter(clickedColor)
        }
        else if (detailcard.state == false){
            binding.favBtn.setColorFilter(unclickedColor)
        }

    }

    }

