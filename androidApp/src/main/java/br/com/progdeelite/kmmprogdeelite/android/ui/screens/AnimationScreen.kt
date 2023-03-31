package br.com.progdeelite.kmmprogdeelite.android.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import br.com.progdeelite.kmmprogdeelite.android.R
import br.com.progdeelite.kmmprogdeelite.navigation.Navigator
import br.com.progdeelite.kmmprogdeelite.tracking.adobe.AnalyticsService
import br.com.progdeelite.kmmprogdeelite.tracking.adobe.ScreenInfo
import com.airbnb.lottie.compose.*

// 1) ADICIONAR DEPENDENCIAS
// 2) CRIAR ROTAS DE NAVEGACÃO
// 3) CRIAR TELA DE ANIMAçÃO - BAIXAR AQUI: https://lottiefiles.com/featured
// 4) USAR ADOBE ANALYTICS PARA RASTREAR USUÁRIO

// ASSISTA O VIDEO SPLASH SCREEN, VC VAI PRECISAR: https://youtu.be/qeurKOMugIU
@Composable
fun AnimationScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash_loading))
            val splashAnimationState = animateLottieCompositionAsState(
                composition = composition,
                //iterations = LottieConstants.IterateForever // IMPORTANTE
            )
            LottieAnimation(
                composition = composition,
                progress = { splashAnimationState.progress }
            )
            navigateToHome(navController, splashAnimationState)
        }
    }
}

@Composable
private fun navigateToHome(navController: NavHostController, splashAnimationState: LottieAnimationState) {
    if (splashAnimationState.isAtEnd && splashAnimationState.isPlaying) {
        AnalyticsService.instance.trackScreen(ScreenInfo.AnimationScreen)
        navController.popBackStack()
        navController.navigate(Navigator.homeGraph.root)
    }
}