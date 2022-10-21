package br.com.progdeelite.kmmprogdeelite.android.utils

// TODO: nav
//import android.os.Bundle
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.MutableState
//import androidx.compose.runtime.State
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.saveable.Saver
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.navigation.NavBackStackEntry
//import androidx.navigation.NavController
//import androidx.navigation.NavDestination
//import androidx.navigation.NavHostController
//import androidx.navigation.Navigator
//import androidx.navigation.compose.ComposeNavigator
//import androidx.navigation.compose.DialogNavigator
//import androidx.navigation.compose.NavHost
//
///**
// * Gets the current navigation back stack entry as a [MutableState]. When the given navController
// * changes the back stack due to a [NavController.navigate] or [NavController.popBackStack] this
// * will trigger a recompose and return the top entry on the back stack.
// *
// * @return a mutable state of the current back stack entry
// */
//@Composable
//fun NavController.currentBackStackEntryAsState(): State<NavBackStackEntry?> {
//    return currentBackStackEntryFlow.collectAsState(null)
//}
//
///**
// * Takes an existing NavHostController and handles the adding of the [ComposeNavigator] and
// * [DialogNavigator]. Additional [Navigator] instances can be passed through [navigators] to
// * be applied to the returned NavController. Note that each [Navigator] must be separately
// * remembered before being passed in here: any changes to those inputs will cause the
// * NavController to be recreated.
// *
// * @see NavHost
// */
//@Composable
//fun rememberNavHostController(
//    navHostController: NavHostController, vararg navigators: Navigator<out NavDestination>
//): NavHostController {
//    return rememberSaveable(inputs = navigators, saver = NavHostControllerSaver(navHostController)) {
//        applyNavigatorsToNavHostController(navHostController)
//    }.apply {
//        for (navigator in navigators) {
//            navigatorProvider.addNavigator(navigator)
//        }
//    }
//}
//
//private fun applyNavigatorsToNavHostController(navHostController: NavHostController) =
//    navHostController.apply {
//        navigatorProvider.addNavigator(ComposeNavigator())
//        navigatorProvider.addNavigator(DialogNavigator())
//    }
//
///**
// * Saver to save and restore the NavHostController across config change and process death.
// */
//private fun NavHostControllerSaver(
//    navHostController: NavHostController
//): Saver<NavHostController, *> = Saver<NavHostController, Bundle>(
//    save = { it.saveState() },
//    restore = { applyNavigatorsToNavHostController(navHostController).apply { restoreState(it) } }
//)