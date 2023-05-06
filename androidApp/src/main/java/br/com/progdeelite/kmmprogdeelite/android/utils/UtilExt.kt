package br.com.progdeelite.kmmprogdeelite.android.utils

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.content.res.Resources
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

// Use only if you are using compose verion <= 1.1.1, otherwise prefer
// Modifier.navigationBarsPadding() >>> See MainActivity
@SuppressLint("DiscouragedApi")
fun getSysNavBarHeight(res: Resources, density: Float): Dp {

    val resName = if (res.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        "navigation_bar_height"
    } else {
        "navigation_bar_height_landscape"
    }

    val id: Int = res.getIdentifier(resName, "dimen", "android")

    return if (id > 0) {
        (res.getDimensionPixelSize(id) / density).dp
    } else {
        0.dp // navigation bar does not exist
    }
}

// Extensão para obter um view apenas com o backstack da rota desejada
@Composable
inline fun <reified VM : ViewModel> NavController.scopedViewModel(
    currentBackStackEntry: NavBackStackEntry,
    route: String
): VM {
    val entry = remember(currentBackStackEntry) { this.getBackStackEntry(route) }
    return viewModel(entry)
}