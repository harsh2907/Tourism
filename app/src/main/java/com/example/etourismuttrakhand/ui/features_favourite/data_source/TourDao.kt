package com.example.etourismuttrakhand.ui.features_favourite.data_source

import androidx.room.Dao
import androidx.room.Query
import com.example.etourismuttrakhand.ui.features_favourite.data_source.entities.Place
import kotlinx.coroutines.flow.Flow

@Dao
interface TourDao {

    @Query("SELECT * FROM tour_table")
    fun getAllFavourites(): Flow<List<Place>>

}