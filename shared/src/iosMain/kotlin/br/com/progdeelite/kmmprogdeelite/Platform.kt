package br.com.progdeelite.kmmprogdeelite

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

class IOSPlatform: Platform {
    override val name: String = "Alô iOS Freaks!"
}

actual fun getPlatform(): Platform = IOSPlatform()

actual abstract class BaseSharedViewModel {

    actual val scope: CoroutineScope = MainScope()

    protected actual open fun onCleared() {
        // outras coisa que deseje limpar
    }

    fun clear() {
        onCleared()
        scope.cancel()
    }
}