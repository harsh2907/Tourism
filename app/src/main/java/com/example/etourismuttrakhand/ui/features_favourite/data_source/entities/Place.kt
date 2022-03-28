package com.example.etourismuttrakhand.ui.features_favourite.data_source.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tour_table")
data class Place(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    val name:String,
    val image:Int,
    val desc:String
)