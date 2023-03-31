package br.com.progdeelite.kmmprogdeelite.navigation

/**
 * Shared routes to be used by iOS and Android
 */
object Navigator {
    val initialGraph = InitialGraph
    val authGraph = AuthGraph
    val authLoginGraph = AuthLoginGraph
    val homeGraph = HomeGraph
    val startGraph = StartGraph
    val insuranceGraph = InsuranceGraph
    val onboardingGraph = OnboardingGraph
    val supportGraph = SupportGraph
    val profileGraph = ProfileGraph
    val bottomNavGraph = BottomNavGraph
}

object InitialGraph {
    const val root = "root_graph"
    const val splash = "splash_screen"
}

object AuthGraph {
    const val root = "auth_graph"
    const val login = "login"
    const val signUp = "sign_up"
    const val forgotPassword = "forgot_password"
}

object AuthLoginGraph {
    const val root = "auth_login_graph"
    const val step1 = "mobile"
    const val step2 = "mtan"
}

object OnboardingGraph {
    const val root = "onboarding_graph"
    const val onboarding = "onboarding"
}

object InsuranceGraph {
    const val root = "insurance_graph"
    const val insurance = "insurance"
}

object ProfileGraph {
    const val root = "profile_graph"
    const val profile = "profile"
}

object SupportGraph {
    const val root = "support_graph"
    const val support = "support"
}

object HomeGraph {
    const val root = "home_graph"
    const val home = "home"
}

object StartGraph {
    const val root = "start_graph"
    const val start = "start"
}

object BottomNavGraph {
    const val root = "nav_graph"
    const val home = "nav_home"
    const val insurance = "nav_insurance"
    const val profile = "nav_profile"
    const val support = "nav_support"
}