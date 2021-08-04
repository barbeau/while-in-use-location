/*
 * Copyright 2021 Sean Barbeau
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.whileinuselocation.data

import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class LocationRepository @Inject constructor(
        private val sharedLocationManager: SharedLocationManager
) {
    /**
     * Status of whether the app is actively subscribed to location changes.
     */
    val receivingLocationUpdates: StateFlow<Boolean> = sharedLocationManager.receivingLocationUpdates

    /**
     * Observable flow for location updates
     */
    fun getLocations() = sharedLocationManager.locationFlow()
}
