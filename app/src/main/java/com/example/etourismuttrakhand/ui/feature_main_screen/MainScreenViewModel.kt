package com.example.etourismuttrakhand.ui.feature_main_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.etourismuttrakhand.ui.feature_details_screen.utils.Data
import com.example.etourismuttrakhand.ui.features_favourite.data_source.entities.Place


class MainScreenViewModel:ViewModel() {

    private var _userName:MutableLiveData<String> = MutableLiveData("")
    val userName = _userName

    fun loadPopularPlaces():ArrayList<Place> {

        val places = ArrayList<Place>()
        var cnt: Int = 0
        while (cnt < 6) {
            val element = Data.allPlaces.random()
            if (!places.contains(element)) {
                places.add(element)
                cnt++
            }
        }
        return places
    }

    fun searchDestination(q:String):ArrayList<Place>{
        val places = ArrayList<Place>()
        Data.allPlaces.forEach {
            if(it.name.startsWith(q))
                places.add(it)
        }
        return places
    }

    fun updateUserName(name:String){
        _userName.value = name
    }
}