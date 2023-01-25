package com.example.my_motivation.data.remote

import com.example.my_motivation.R
import com.example.my_motivation.data.model.Categorycard
import com.example.my_motivation.data.model.Detailcard

class Repository(val api: MotivationApi){

    var detailCards: List<Detailcard> = listOf()

    suspend fun loadDetailcard(){
         detailCards = api.retrofitService.getResponse()

    }
    fun loadcategorycard(): List<Categorycard> {
        return listOf(
        Categorycard(
            "Alltag", R.drawable.alltagkategorie),
            Categorycard(
                "Durchhalten und Erfolg", R.drawable.durchhaltenunderfolgkategorie),
            Categorycard(
                "Mut", R.drawable.mutkategorie),
            Categorycard(
                "Sport", R.drawable.sportkategorie),
            Categorycard(
                "Veränderungen anpacken", R.drawable.veraenderungkategorie),
            Categorycard(
                "Englische Motivationssprüche", R.drawable.englischkategorie),
            Categorycard(
                "Humorvolle Motivationssprüche", R.drawable.humorkategorie)
            )
    }
}
