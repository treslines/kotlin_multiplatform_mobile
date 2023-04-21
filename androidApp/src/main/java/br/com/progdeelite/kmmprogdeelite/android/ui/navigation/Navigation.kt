package br.com.progdeelite.kmmprogdeelite.android.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.progdeelite.kmmprogdeelite.android.ui.components.BottomNavigationBar
import br.com.progdeelite.kmmprogdeelite.android.ui.screens.*
import br.com.progdeelite.kmmprogdeelite.navigation.Navigator
import br.com.progdeelite.kmmprogdeelite.viewmodels.OnBoardingViewModel

// 1) COMO CRIAR O ROOT-NAV-GRAPH
// 2) COMO ADICIONAR ROTAS
// 3) COMO INTEGRAR BOTTOM NAVIGATION BAR
// 4) ADICIONAR A MAIN ACTIVITY
@Composable
fun RootNavigationGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        route = Navigator.initialGraph.root,
        startDestination = Navigator.initialGraph.splash
    ) {
        composable(route = Navigator.initialGraph.splash) {
            AnimationScreen(navController = navController)
        }
        composable(route = Navigator.homeGraph.root) {
            val mainNavController = rememberNavController()
            Scaffold(
                backgroundColor = Color.Transparent, // IMPORTANTE PARA PODER VER O EFEITO DO GRADIENTE
                bottomBar = {
                    BottomNavigationBar(navController = mainNavController)
                }
            ) {
                Column(modifier = Modifier.padding(it)) {
                    BottomNavGraph(navController = mainNavController)
                }
            }
        }
    }
}

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Navigator.bottomNavGraph.root,
        startDestination = Navigator.bottomNavGraph.home
    ) {
        composable(route = Navigator.bottomNavGraph.home) {
            HomeScreen(navController = navController)
        }
        composable(route = Navigator.bottomNavGraph.insurance) {
            Confirm2faScreen({}, {}, {navController.navigate(Navigator.onboardingGraph.onboarding)})
        }
        composable(route = Navigator.bottomNavGraph.support) {
            SupportScreen(navController = navController)
        }
        composable(route = Navigator.bottomNavGraph.profile) {
            ProfileScreen(navController = navController)
        }
        composable(route = Navigator.authGraph.login) {
            LoginScreen(onClose = {navController.navigate(Navigator.bottomNavGraph.root)},
                onNext = {navController.navigate(Navigator.bottomNavGraph.profile)}
            )
        }
        composable(route = Navigator.onboardingGraph.onboarding) {
            OnBoardingScreen(viewModel = OnBoardingViewModel())
        }
    }
}

