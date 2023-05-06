package br.com.progdeelite.kmmprogdeelite.android.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import br.com.progdeelite.kmmprogdeelite.android.ui.components.BottomNavigationBar
import br.com.progdeelite.kmmprogdeelite.android.ui.screens.*
import br.com.progdeelite.kmmprogdeelite.android.utils.scopedViewModel
import br.com.progdeelite.kmmprogdeelite.navigation.Graphs
import br.com.progdeelite.kmmprogdeelite.navigation.Args
import br.com.progdeelite.kmmprogdeelite.viewmodels.LoginViewModel
import br.com.progdeelite.kmmprogdeelite.viewmodels.RegisterViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

// 1) CRIAR SCREENS DE NAVEGACÃO (AJUSTAR ANIMATIONSCREEN)
// 2) CRIAR NAVIGATION GRAPH (VIDE DIAGRAMA)
// 3) AJUSTAR MAIN ACTIVITY
// 4) COMO TESTAR DEEPLINKS NO TERMINAL:
// EX: adb shell am start -a android.intent.action.VIEW -d "yourscheme://yourcompany.com/XXXXXXX"
// Onde XXXXXXX > no da tela > ex: "login" OU "support" OU "home" etc.

@Composable
fun RootNavigationGraph(
    navController: NavHostController = rememberNavController(),
    isDeeplink: Boolean,
    deeplinkDestination: String
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.statusBarDarkContentEnabled = true

    Scaffold(
        backgroundColor = Color.Transparent,
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            BottomNavHost(
                navController = navController,
                isDeeplink = isDeeplink,
                deeplinkDestination = deeplinkDestination
            )
        }
    }
}

@Composable
fun BottomNavHost(navController: NavHostController, isDeeplink: Boolean, deeplinkDestination: String) {
    NavHost(
        navController = navController,
        route = Graphs.AppEntryGraph.root,
        startDestination = if (isDeeplink) Graphs.HomeGraph.root else Graphs.AppEntryGraph.splash
    ) {

        composable(route = Graphs.AppEntryGraph.splash) {
            val systemUiController = rememberSystemUiController()
            systemUiController.statusBarDarkContentEnabled = false

            AnimationScreen(navController = navController)
        }
        homeGraph(navController)
        insuranceGraph(navController)
        supportGraph(navController)
        registerGraph(navController)
        loginGraph(navController)
    }
}

fun NavGraphBuilder.homeGraph(navController: NavHostController) {
    navigation(
        route = Graphs.HomeGraph.root,
        startDestination = Graphs.HomeGraph.Home.route
    ) {
        composable(
            route = Graphs.HomeGraph.Home.route,
            deepLinks = listOf(
                // não tenho parametro nem argumento
                navDeepLink { uriPattern = Graphs.HomeGraph.Home.deeplink }
            )
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Graphs.HomeGraph.Profile.route,
            deepLinks = listOf(
                // não tenho parametro nem argumento
                navDeepLink { uriPattern = Graphs.HomeGraph.Profile.deeplink }
            )
        ) {
            ProfileScreen(navController = navController)
        }
    }
}

fun NavGraphBuilder.insuranceGraph(navController: NavHostController) {
    navigation(
        route = Graphs.InsuranceGraph.root,
        startDestination = Graphs.InsuranceGraph.Insurance.route
    ) {
        composable(
            route = Graphs.InsuranceGraph.Insurance.route,
            deepLinks = listOf(
                // não tenho parametro nem argumento
                navDeepLink { uriPattern = Graphs.InsuranceGraph.Insurance.deeplink }
            )
        ) {
            InsuranceScreen(navController = navController)
        }
    }
}

fun NavGraphBuilder.supportGraph(navController: NavHostController) {
    navigation(
        route = Graphs.SupportGraph.root,
        startDestination = Graphs.SupportGraph.Support.route
    ) {
        composable(
            route = Graphs.SupportGraph.Support.route,
            deepLinks = listOf(
                // não tenho parametro nem argumento
                navDeepLink { uriPattern = Graphs.SupportGraph.Support.deeplink }
            )
        ) {
            SupportScreen(navController = navController)
        }
    }
}

fun NavGraphBuilder.registerGraph(navController: NavHostController) {
    val root = Graphs.AuthRegisterGraph.root
    navigation(
        route = root,
        startDestination = Graphs.AuthRegisterGraph.Register.route
    ) {
        val registerStartScreen = Graphs.AuthRegisterGraph.Register.NavArgs.start_screen
        composable(
            route = Graphs.AuthRegisterGraph.Register.route,
            arguments = listOf(
                navArgument(Args.from(registerStartScreen)) {
                    defaultValue = Graphs.HomeGraph.Home.startRoute
                }
            ), // Argumento passado aqui
            deepLinks = listOf(
                // tenho APENAS 1 argumento
                navDeepLink { uriPattern = Graphs.AuthRegisterGraph.Register.deeplink }
            )
        ) {
            // obter argumeto aqui que definimos no composable acima
            val startScreenForRegister = it.arguments?.getString(Args.from(registerStartScreen))
            // criar um viewmodel apenas com o navigation stack de REGISTER
            val viewModel: RegisterViewModel = navController.scopedViewModel(it, root)
            // instruir o modelo, para que ele saiba para onde navegar, no caso para
            // a tela de start passada como argumento
            viewModel.startScreen = startScreenForRegister

            RegisterScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(
            // NAO DEFINE DEEPLINK
            route = Graphs.AuthRegisterGraph.Otp.route
        ) {
            // criar um viewmodel apenas com o navigation stack de REGISTER
            val viewModel: RegisterViewModel = navController.scopedViewModel(it, root)

            ConfirmRegisterScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}

fun NavGraphBuilder.loginGraph(navController: NavHostController) {
    val root = Graphs.AuthLoginGraph.root
    navigation(
        route = root,
        startDestination = Graphs.AuthLoginGraph.Login.route
    ) {
        val loginStartScreen = Graphs.AuthLoginGraph.Login.NavArgs.start_screen
        composable(
            route = Graphs.AuthLoginGraph.Login.route,
            arguments = listOf(navArgument(Args.from(loginStartScreen)) { defaultValue = Graphs.HomeGraph.Home.startRoute }),
            deepLinks = listOf(
                navDeepLink { uriPattern = Graphs.AuthLoginGraph.Login.deeplink }
            )
        ) {
            // obter argumeto aqui que defininos no composable acima
            val startScreenForLogin = it.arguments?.getString(Args.from(loginStartScreen))
            // criar um viewmodel apenas com o navigation stack de LOGIN
            val viewModel: LoginViewModel = navController.scopedViewModel(it, root)
            // instruir o modelo, para que ele saiba para onde navegar, no caso
            // para a tela de start passada como argumento
            viewModel.startScreen = startScreenForLogin

            LoginScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(
            // NAO DEFINE DEEPLINK
            route = Graphs.AuthLoginGraph.Otp.route
        ) {
            // criar um viewmodel apenas com o navigation stack de LOGIN
            val viewModel: LoginViewModel = navController.scopedViewModel(it, root)

            ConfirmLoginScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}