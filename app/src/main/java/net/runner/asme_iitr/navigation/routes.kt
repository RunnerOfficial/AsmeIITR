package net.runner.asme_iitr.navigation


sealed class NavigationRoutes(val route: String) {
    object SplashScreen : NavigationRoutes("splash_screen")
    object LoginOptions : NavigationRoutes("login_options")
    object MemberMainScreen : NavigationRoutes("member_main_screen")
}
