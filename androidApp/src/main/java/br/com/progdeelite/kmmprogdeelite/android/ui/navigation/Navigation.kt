package br.com.progdeelite.kmmprogdeelite.android.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.progdeelite.kmmprogdeelite.android.ui.components.BottomNavigationBar
import br.com.progdeelite.kmmprogdeelite.android.ui.components.DummyScreen
import br.com.progdeelite.kmmprogdeelite.android.ui.screens.AnimationScreen
import br.com.progdeelite.kmmprogdeelite.navigation.Navigator

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
            DummyScreen(name = "TELA HOME") {
                // ACÃO DE NAVEGAçÃO AQUI...
            }
        }
        composable(route = Navigator.bottomNavGraph.insurance) {
            DummyScreen(name = "TELA SEGURO") {
                // ACÃO DE NAVEGAçÃO AQUI...
            }
        }
        composable(route = Navigator.bottomNavGraph.support) {

            DummyScreen(name = "TELA SUPORTE") {
                // ACÃO DE NAVEGAçÃO AQUI...
            }
        }
        composable(route = Navigator.bottomNavGraph.profile) {
            DummyScreen(name = "TELA PERFIL") {
                // ACÃO DE NAVEGAçÃO AQUI...
            }
        }
    }
}

