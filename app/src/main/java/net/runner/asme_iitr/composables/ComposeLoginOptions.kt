package net.runner.asme_iitr.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.runner.asme_iitr.R
import net.runner.asme_iitr.navigation.NavigationRoutes
import net.runner.asme_iitr.ui.theme.DarkText

@Composable
fun LoginOptions(navController: NavController){
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    val gradientBrush = getBackGroundGradientBrush(screenWidth,screenHeight)

    val scope = rememberCoroutineScope()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBrush),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){

                CardViewLogin(painter = painterResource(id = R.drawable.member),"Member"){
                    scope.launch {
                        withContext(Dispatchers.Main){
                            redirectScreen(navController, NavigationRoutes.MemberMainScreen.route)
                        }
                    }
                }
                CardViewLogin(painter = painterResource(id = R.drawable.admin),"Admin"){
//                        pushData("jsfds")
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){

                Text(text = "Not From our Team ? Login as ", style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp, fontWeight = FontWeight.Bold))
                Text(
                    text = "Guest",
                    style = MaterialTheme.typography.bodyMedium
                        .copy(
                            fontWeight = FontWeight.Bold, fontSize = 18.sp, color = DarkText
                        )
                )

            }

        }


    }

}
@Composable
fun CardViewLogin(painter: Painter,text:String,onclick:() -> Unit){
    Card (
        colors = CardDefaults.cardColors(
         containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 30.dp
        ),
        modifier = Modifier.
        size(width = 150.dp, height = 150.dp),
        onClick = onclick
    ){
            Column (
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painter, contentDescription = "userType", modifier = Modifier.fillMaxHeight(0.8f))
                Text(text = text, style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold))
            }
    }
}

fun redirectScreen(navController: NavController,route:String){
        navController.navigate(route){
            popUpTo(NavigationRoutes.LoginOptions.route) { inclusive = true }
        }
}