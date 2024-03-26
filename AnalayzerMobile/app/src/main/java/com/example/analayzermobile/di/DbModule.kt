package com.example.analayzermobile.di

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.analayzermobile.data.sqlite.LocationDbHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    fun providesSQLiteLocationDB(@ApplicationContext context: Context): SQLiteDatabase {
        return LocationDbHelper(context).writableDatabase
    }
}
