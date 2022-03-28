package com.example.etourismuttrakhand.ui.features_favourite.data_source.entities

import androidx.room.Entity

@Entity(tableName = "tour_table")
data class Place(
    val name:String,
    val image:Int,
    val desc:String
)