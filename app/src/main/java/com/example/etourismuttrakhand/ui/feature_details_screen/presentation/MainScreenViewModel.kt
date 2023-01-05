package com.example.etourismuttrakhand.ui.feature_details_screen.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.etourismuttrakhand.ui.feature_details_screen.backend.Data
import com.example.etourismuttrakhand.ui.feature_details_screen.models.Place


class MainScreenViewModel:ViewModel() {

    private val userName:MutableLiveData<String> by lazy { MutableLiveData("") }

    fun loadPopularPlaces():List<Place> {
        val places = mutableSetOf<Place>()
        while (places.size!=6) {
            val element = Data.allPlaces.random()
            places.add(element)
        }
        return places.toList()
    }



    fun searchDestination(q:String):List<Place> = Data.allPlaces.filter { it.name.contains(q.lowercase()) }

    fun updateUserName(name:String){
        userName.value = name
    }
}