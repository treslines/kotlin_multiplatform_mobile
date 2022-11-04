package br.com.progdeelite.kmmprogdeelite.viewmodels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

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