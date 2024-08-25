package net.runner.asme_iitr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.runner.asme_iitr.composables.LoginOptions
import net.runner.asme_iitr.composables.Member.MemberLogin
import net.runner.asme_iitr.composables.SplashScreen
import net.runner.asme_iitr.navigation.NavigationRoutes
import net.runner.asme_iitr.ui.theme.AsmeIITRTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AsmeIITRTheme {
                NavRoutes()
            }
        }
    }
}

@Composable
fun NavRoutes() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.LoginOptions.route
    ) {
        composable(route = NavigationRoutes.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = NavigationRoutes.LoginOptions.route) {
            LoginOptions(navController)
        }
        composable(route = NavigationRoutes.MemberMainScreen.route) {
            MemberLogin()
        }
    }
}
