package net.runner.asme_iitr.navigation

sealed class Screen(val title: String) {
    object Activities : Screen("Activities")
    object Chat : Screen("Chat")
    object Projects : Screen("Projects")
    object Assignment : Screen("Assignment")
    object More : Screen("More")
}
sealed class AdminScreen(val title: String) {
    object Activities : AdminScreen("Activities")
    object Chat : AdminScreen("Chat")
    object Projects : AdminScreen("Projects")
    object Assignment : AdminScreen("Assignment")
}

sealed class Drawer(val title: String) {
    object Drawer1 : Drawer("Drawer1")
    object Drawer2 : Drawer("Drawer2")
    object Drawer3 : Drawer("Drawer3")
}
