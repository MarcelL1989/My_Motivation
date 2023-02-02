package com.example.my_motivation.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Detailcard (


    val bild: String,
    val spruch: String,
    val kategorie: String,
    @PrimaryKey
    val id: Int
        )