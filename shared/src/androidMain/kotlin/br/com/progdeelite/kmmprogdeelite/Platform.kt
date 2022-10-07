package br.com.progdeelite.kmmprogdeelite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual abstract class BaseSharedViewModel: ViewModel() {

    actual val scope = viewModelScope

    actual override fun onCleared() {
        super.onCleared()
    }
}