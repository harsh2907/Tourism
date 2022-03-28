package com.example.etourismuttrakhand.ui.features_favourite.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.etourismuttrakhand.ui.features_favourite.data_source.entities.Place

@Database(entities = [Place::class], version = 1, exportSchema = false)
abstract class TourDatabase: RoomDatabase() {
    abstract val dao:TourDao
}