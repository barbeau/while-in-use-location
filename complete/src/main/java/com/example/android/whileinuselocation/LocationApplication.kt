package com.example.android.whileinuselocation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.GlobalScope

// Required for Hilt dependency injection
@HiltAndroidApp
class LocationApplication : Application() {
    // No need to cancel this scope as it'll be torn down with the process - see https://medium.com/androiddevelopers/coroutines-patterns-for-work-that-shouldnt-be-cancelled-e26c40f142ad
    val applicationScope = GlobalScope
}