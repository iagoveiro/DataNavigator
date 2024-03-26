package com.example.analayzermobile

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AnalyzerApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}