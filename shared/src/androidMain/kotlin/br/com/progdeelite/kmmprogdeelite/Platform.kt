package br.com.progdeelite.kmmprogdeelite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

// TODO: nav
//import androidx.navigation.NavHostController
//import br.com.progdeelite.kmmprogdeelite.navigation.Navigation
//import br.com.progdeelite.kmmprogdeelite.utils.AndroidApp

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual abstract class BaseSharedViewModel: ViewModel()/*, Navigation TODO: nav */  {

    actual val scope = viewModelScope

    // private val navigator: NavHostController = AndroidApp.navHostController // TODO nav

    actual override fun onCleared() {
        super.onCleared()
    }

//     TODO: nav
//    override fun navigateTo(destination: String) {
//        navigator.navigate(destination)
//    }
//
//    override fun navigateToButRemoveBackStack(destination: String) {
//        navigator.popBackStack(destination, true)
//    }
}