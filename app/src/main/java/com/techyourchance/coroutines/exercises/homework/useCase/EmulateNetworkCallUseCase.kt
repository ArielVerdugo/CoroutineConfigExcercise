package com.techyourchance.coroutines.exercises.homework.useCase

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class EmulateNetworkCallUseCase {

    suspend fun emulateNetworkCall() : List<String> =
        withContext(CoroutineName("use case network service") + Dispatchers.IO) {
        delay(4000)
        return@withContext listOf("one", "two", "three", "four","one", "two", "three", "four")
    }
}