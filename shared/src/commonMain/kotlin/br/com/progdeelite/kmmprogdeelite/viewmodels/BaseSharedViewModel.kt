package br.com.progdeelite.kmmprogdeelite.viewmodels

import kotlinx.coroutines.CoroutineScope

expect abstract class BaseSharedViewModel() {
    val scope: CoroutineScope
    protected fun onCleared()
}