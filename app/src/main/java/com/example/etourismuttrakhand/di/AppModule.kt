package com.example.etourismuttrakhand.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.etourismuttrakhand.ui.features_favourite.data_source.TourDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext
        context: Context
    ) =
        Room.databaseBuilder(
            context,
            TourDatabase::class.java,
            "tour_db"
        ).fallbackToDestructiveMigration()
            .build()
}
