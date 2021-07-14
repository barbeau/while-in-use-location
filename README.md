While-in-use Location + Room, Flow, and Hilt
===============================

This repository is derived from the while-in-use-location, location-samples, and kotlin-couroutines codelabs and repositories:
* https://developers.google.com/codelabs/while-in-use-location
* https://github.com/googlecodelabs/while-in-use-location
* https://github.com/android/location-samples
* https://github.com/googlecodelabs/kotlin-coroutines

## tl;dr

This project replaces `LocalBroadcastManager` with a custom `SharedLocationManager` that uses `callbackFlow` for to share location updates with an `Activity` and a `Service`.

## Description

The detailed differences between the original [while-in-use-location code lab](https://developers.google.com/codelabs/while-in-use-location) and this project are:
1. *callbackFlow observer implementation* - `LocalBroadcastManager` was originally used to share new locations obtained in the `ForegroundOnlyLocationService` with the `MainActivity`. As discussed [here](https://github.com/googlecodelabs/while-in-use-location/issues/12), this "event bus" pattern is no longer recommended because it encourages app architecture layer violations. This project replaces `LocalBroadcastManager` with a data repository implemented with a custom `SharedLocationManager`. The `ForegroundOnlyLocationService` and `MainActivity` is notified of location updates via Kotlin Flow (see reference [here](https://www.raywenderlich.com/9799571-kotlin-flow-for-android-getting-started)) and specifically `callbackFlow`. [Flow.flowWithLifecycle](https://medium.com/androiddevelopers/room-flow-273acffe5b57) is used to observe the Flow in the Activity and Service to make sure all observing resources are torn down when the Activity and Service are destroyed.
1. *Hilt for dependency injection* - To make the data repository available to the service and activity, [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) is used. See additional useful resources on Hilt in [this video](https://youtu.be/B56oV3IHMxg?t=444), in [this codelab](https://developer.android.com/codelabs/android-hilt#4), and in [this repo example](https://github.com/googlecodelabs/android-hilt). 
1. *Lifecycle extensions* - To access the data repository within the service and activity using scoped coroutines, the [KTX Lifecycle extensions](https://developer.android.com/kotlin/ktx#lifecycle) are used. This ensures that any coroutines that are running within the scope of the activity or service lifecycle will be destroyed when those respective objects are destroyed.
1. *Other minor changes:*
    - Location update frequency increased to once per second to make it easier to observe data flow
    - MainActivity text view is now scrollable
    
See the code diff of the two projects that highlights the changes when replacing `LocalBroadcastManager` with callbackFlow [here](https://github.com/googlecodelabs/while-in-use-location/compare/master...barbeau:no-database).