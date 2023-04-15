package br.com.progdeelite.kmmprogdeelite.android.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.com.progdeelite.kmmprogdeelite.android.ui.theme.TextStyles
import br.com.progdeelite.kmmprogdeelite.navigation.BottomBarItem
import br.com.progdeelite.kmmprogdeelite.resources.Resources
import br.com.progdeelite.kmmprogdeelite.tracking.adobe.AnalyticsService

object BottomBarConfigList {
    val all = listOf(
        BottomBarItem.Home,
        BottomBarItem.Insurance,
        BottomBarItem.Support,
        BottomBarItem.Profile
    )
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val showNavigationItems = BottomBarConfigList.all.any { it.route == currentDestination?.route }
    if (showNavigationItems) {

        // We are using: WindowCompat.setDecorFitsSystemWindows(window, false) in the MainActivity
        // to fit our header over the status bar. For that reason we need to compensate the height
        // of the system navigation bar. Otherwise it would overlay the bottom navigation bar. compose <= 1.1.1
        // val res = LocalContext.current.resources
        // val density = LocalDensity.current.density
        // Column (modifier = Modifier.padding(bottom = getSysNavBarHeight(res, density))) {
        Column {
            BottomNavigation(
                backgroundColor = Resources.Theme.surface.getColor()
            ) {
                BottomBarConfigList.all.forEach { itemConfig ->
                    AddItem(
                        itemConfig = itemConfig,
                        currentDestination = currentDestination,
                        navController = navController
                    )
                }
            }
            // EXIBINDO ONLINE OFFLINE STATUS (VEJA O VIDEO, VC VAI PRECISAR 100% NA EMPRESA)
            ShowConnectivityStatus() // LINK VIDEO: https://youtu.be/w7dbyXGfsco
        }
    } else {
        ShowConnectivityStatus()
    }
}

@Composable
fun RowScope.AddItem(
    itemConfig: BottomBarItem,
    currentDestination: NavDestination?,
    navController: NavHostController,
    navIconContentDescription: String? = null,
    analytics: AnalyticsService = AnalyticsService.instance
) {
    BottomNavigationItem(
        label = {
            AccessibilityText(
                text = itemConfig.title.localized,
                style = TextStyles.navBarItem,
                maxLines = 1,
            )
        },
        icon = {
            Icon(
                imageVector = ImageVector.vectorResource(itemConfig.icon.id),
                contentDescription = navIconContentDescription
            )
        },
        selected = currentDestination?.hierarchy?.any { it.route == itemConfig.route } == true,
        selectedContentColor = Resources.Theme.selectedContentColor.getColor(),
        unselectedContentColor = Resources.Theme.unselectedContentColor.getColor(),
        onClick = {
            // USANDO ADOBE ANALYTICS (VEJA O VIDEO QUE FICOU TOP, VC VAI PRECISAR NA EMPRESA 100%)
            analytics.trackScreen(itemConfig.screenInfo) // LINK VIDEO: https://youtu.be/tLM0HUQc7pA
            analytics.trackAction(itemConfig.action)
            navController.navigate(itemConfig.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}