package com.example.android.whileinuselocation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Required for Hilt dependency injection
@HiltAndroidApp
class LocationApplication : Application() {
}