package net.runner.asme_iitr.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import net.runner.asme_iitr.navigation.NavigationRoutes

@Composable
fun SplashScreen(navController: NavController){
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    val gradientBrush = getBackGroundGradientBrush(screenWidth,screenHeight)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBrush),
        contentAlignment = Alignment.Center
    ) {

    }

    LaunchedEffect(Unit) {
        delay(0L)
        withContext(Dispatchers.Main){
        navController.navigate(NavigationRoutes.LoginOptions.route) {
            popUpTo(NavigationRoutes.SplashScreen.route) { inclusive = true }
           }
        }
    }
}