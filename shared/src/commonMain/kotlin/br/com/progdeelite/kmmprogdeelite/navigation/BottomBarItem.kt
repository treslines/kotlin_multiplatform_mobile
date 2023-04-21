package br.com.progdeelite.kmmprogdeelite.navigation

import br.com.progdeelite.kmmprogdeelite.resources.ImageResource
import br.com.progdeelite.kmmprogdeelite.resources.Resources
import br.com.progdeelite.kmmprogdeelite.resources.TextResource
import br.com.progdeelite.kmmprogdeelite.tracking.adobe.AnalyticsAction
import br.com.progdeelite.kmmprogdeelite.tracking.adobe.ScreenInfo

// 1) ESPECIFIQUE OS RECURSOS
//      - ImageResource
//      - StringResource
// 2) CRIE E DEFINA OS VECTORES DE IMAGENS E TEXTOS EM STRINGS.XML
//      - strings.xml & drawable
// 3) CRIE CLASSE BOTTOM BAR ITEM (POR ISSO PUBLIQUEI O VIDEO ANTERIOR)
//      - Navigation.kt (rotas) - ASSISTA O VIDEO, VC VAI PRECISAR: https://youtu.be/qeurKOMugIU
// 4) DEFINA A BottomNavigationBar
//      - Theme (cores dos itens selecionados e nao selecionados)
//      - TextStyles (definir estilo da barra de navegação)
// 5) JÁ SEGUE O CANAL PARA NAO PERDER A CONTINUAçÃO - VC VAI PRECISAR 100%

abstract class BottomBarItem(
    val route: String,
    val title: TextResource,
    val icon: ImageResource,
    val action: AnalyticsAction,
    val screenInfo: ScreenInfo
) {

    object Home : BottomBarItem(
        route = Navigator.bottomNavGraph.home,
        title = Resources.Strings.nav_bar_home,
        icon = Resources.Image.home,
        action = AnalyticsAction.NavHomeAction,
        screenInfo = ScreenInfo.HomeScreen
    )

    object Insurance : BottomBarItem(
        route = Navigator.bottomNavGraph.insurance,
        title = Resources.Strings.nav_bar_insurance,
        icon = Resources.Image.insurance,
        action = AnalyticsAction.NavInsuranceAction,
        screenInfo = ScreenInfo.InsuranceScreen
    )

    object Support : BottomBarItem(
        route = Navigator.bottomNavGraph.support,
        title = Resources.Strings.nav_bar_support,
        icon = Resources.Image.support,
        action = AnalyticsAction.NavSupportAction,
        screenInfo = ScreenInfo.SupportScreen
    )

    object Profile : BottomBarItem(
        route = Navigator.bottomNavGraph.profile,
        title = Resources.Strings.nav_bar_profile,
        icon = Resources.Image.profile,
        action = AnalyticsAction.NavProfileAction,
        screenInfo = ScreenInfo.ProfileScreen
    )
}

// 1) DEFINIR AS SUB ROTAS
// 2) ADAPTER SUA BOTTOM NAVIGATION BAR

// Any sub navigation point (screen) which should show the bottom navigation bar
object BottomBarSubItems {
    val topLevelHomeItem = listOf("")

    val topLevelInsuranceItem = listOf(
        Navigator.authLoginGraph.mobileNumber,
        Navigator.authLoginGraph.confirmSms
    )
    val topLevelSupportItem = listOf(
        Navigator.authGraph.login,
        Navigator.authGraph.signUp,
        Navigator.authGraph.forgotPassword,
    )
    val topLevelHelpItem = listOf(
        Navigator.profileGraph.settings
    )
}