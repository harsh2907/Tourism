package com.example.etourismuttrakhand.ui.feature_details_screen.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class Place(
    var id:Int?=null,
    val name:String,
    val image:List<Int>,
    val desc:String,
    val homeStayId:Int
):Serializable