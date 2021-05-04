While-in-use Location Codelab Repository + Room, Flow, and Hilt
===============================

This repository is derived from the while-in-use location codelab and repository:
* https://developers.google.com/codelabs/while-in-use-location
* https://github.com/googlecodelabs/while-in-use-location

The differences between the original project and this one are:
1. *Room + Flow observer implementation* - `LocalBroadcastManager` was originally used to share new locations obtained in the `ForegroundOnlyLocationService` with the `MainActivity`. As discussed [here](https://github.com/googlecodelabs/while-in-use-location/issues/12), this "event bus" pattern is no longer recommended because it encourages app architecture layer violations. This project replaces `LocalBroadcastManager` with a data repository implemented via [Room](https://developer.android.com/training/data-storage/room). The `ForegroundOnlyLocationService` persists new locations to Room, and `MainActivity` is notified of changes in the Room database [via Kotlin Flow (transformed to LiveData)](https://medium.com/androiddevelopers/room-flow-273acffe5b57).
1. *Hilt for dependency injection* - To make the data repository (Room database) available to the service and activity, [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) is used. See additional useful resources on Hilt and Room in [this video](https://youtu.be/B56oV3IHMxg?t=444), in [this codelab](https://developer.android.com/codelabs/android-hilt#4), and in [this repo example](https://github.com/googlecodelabs/android-hilt). 
1. *Lifecycle extensions* - To access the data repository within the service and activity using scoped coroutines, the [KTX Lifecycle extensions](https://developer.android.com/kotlin/ktx#lifecycle) are used. This ensures that any coroutines that are running within the scope of the activity or service lifecycle will be destroyed when those respective objects are destroyed.
1. Other minor changes:
    - Location update frequency increased to once per second to make it easier to observe data flow
    - MainActivity text view is now scrollable

License
-------

Copyright 2019 Google, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
