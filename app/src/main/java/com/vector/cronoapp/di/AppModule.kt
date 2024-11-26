package com.vector.cronoapp.di

import android.content.Context
import androidx.room.Room
import com.vector.cronoapp.room.CronosDatabase
import com.vector.cronoapp.room.CronosDatabaseDao
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
    fun provideCronosDao(cronosDatabase: CronosDatabase): CronosDatabaseDao{
        return cronosDatabase.cronosDao()
    }

    @Singleton
    @Provides
    fun provideCronosDatabase(@ApplicationContext context: Context): CronosDatabase{
        return Room.databaseBuilder(
            context = context,
            klass = CronosDatabase::class.java,
            name = "cronosDB"
        ).fallbackToDestructiveMigration().build()
    }

}