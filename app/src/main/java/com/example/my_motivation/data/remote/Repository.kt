package com.example.my_motivation.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.my_motivation.R
import com.example.my_motivation.data.model.Categorycard
import com.example.my_motivation.data.model.Detailcard

class Repository {

    suspend fun loadDetailcard(): List<Detailcard> {
        return MotivationApi.retrofitService.getResponse()

    }

    fun loadcategorycard(): List<Categorycard> {
        return listOf(
            Categorycard(
                "Alltag", R.drawable.alltagkategorie,
                listOf(1,2,3,4,5)
            ),
            Categorycard(
                "Durchhalten und Erfolg", R.drawable.durchhaltenunderfolgkategorie,
                listOf(6,7,8,9,10)
            ),
            Categorycard(
                "Mut", R.drawable.mutkategorie,
                listOf(11,12,13,14,15)
            ),
            Categorycard(
                "Sport", R.drawable.sportkategorie,
                listOf(16,17,18,19,20)
            ),
            Categorycard(
                "Veränderungen anpacken", R.drawable.veraenderungkategorie,
                listOf(21,22,23,24,25)
            ),
            Categorycard(
                "Englische Motivationssprüche", R.drawable.englischkategorie,
                listOf(26,27,28,29,30)
            ),
            Categorycard(
                "Humorvolle Motivationssprüche", R.drawable.humorkategorie,
                listOf(31,32,33,34,35)
            )
        )
    }
}

