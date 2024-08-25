package net.runner.jetpacktests.composables.Admin

//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AccountCircle
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.DrawerState
//import androidx.compose.material3.DrawerValue
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.FloatingActionButton
//import androidx.compose.material3.HorizontalDivider
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.ModalDrawerSheet
//import androidx.compose.material3.ModalNavigationDrawer
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.NavigationBarItemColors
//import androidx.compose.material3.NavigationBarItemDefaults
//import androidx.compose.material3.NavigationDrawerItem
//import androidx.compose.material3.NavigationDrawerItemDefaults
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
//import androidx.compose.material3.rememberDrawerState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.RectangleShape
//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.platform.LocalConfiguration
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.launch
//import net.runner.jetpacktests.R
//import net.runner.jetpacktests.composables.getBackGroundGradientBrush
//import net.runner.jetpacktests.navigation.AdminScreen
//import net.runner.jetpacktests.navigation.Drawer
//import net.runner.jetpacktests.navigation.Screen
//import net.runner.jetpacktests.ui.theme.BgGradient1
//import net.runner.jetpacktests.ui.theme.BottomNavBarIconText
//import net.runner.jetpacktests.ui.theme.BottomNavBarIndicator
//import net.runner.jetpacktests.ui.theme.DarkText
//import net.runner.jetpacktests.ui.theme.DrawerColor
//import net.runner.jetpacktests.ui.theme.PrimaryColor
//
//@Composable
//fun MemberLogin(){
//    Main()
//}
//
//@Composable
//fun Main() {
//    val configuration = LocalConfiguration.current
//    val screenWidth = configuration.screenWidthDp.dp
//    val screenHeight = configuration.screenHeightDp.dp
//    val gradientBrush = getBackGroundGradientBrush(screenWidth,screenHeight)
//
//    var currentScreen by remember { mutableStateOf<AdminScreen>(AdminScreen.Activities) }
//
//    val scope = rememberCoroutineScope()
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(gradientBrush)
//    ){
//
//            Scaffold(
//                topBar = {
//                    MemberTopAppBar(scope)
//                },
//                bottomBar = {
//                    BottomNavigationBar(currentScreen) { screen ->
//                        currentScreen = screen
//                    }
//                },
//                floatingActionButton = {
//                    FloatingActionButton(onClick = {  },) {
//                        Icon(Icons.Default.Add, contentDescription = "Add")
//                    }
//                },
//                containerColor = Color.Transparent
//            ) { innerPadding ->
//                MainContent(currentScreen, modifier = Modifier.padding(innerPadding))
//            }
//        }
//
//
//}
//@Composable
//fun BottomNavigationBar(currentScreen: Screen, onScreenSelected: (Screen) -> Unit) {
//
//    NavigationBar (
//        containerColor = Color.Transparent,
//        contentColor = DarkText,
//        tonalElevation = 12.dp
//    ){
//        NavigationBarItem(
//            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
//            label = { Text("Home") },
//            selected = currentScreen is Screen.Activities,
//            onClick = {
//                onScreenSelected(AdminScreen.Activities)
//            },
//            colors = navigationBarItemColors()
//        )
//        NavigationBarItem(
//            icon = { Icon(Icons.Default.Search, contentDescription = "Search")},
//            label = { Text("Search") },
//            selected = currentScreen is AdminScreen.Activities,
//            onClick = {onScreenSelected(AdminScreen.Activities)},
//            colors = navigationBarItemColors()
//
//        )
//        NavigationBarItem(
//            icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Profile") },
//            label = { Text("Profile") },
//            selected = currentScreen is AdminScreen.Activities,
//            onClick = { onScreenSelected(AdminScreen.Activities)},
//            colors = navigationBarItemColors()
//        )
//    }
//}
//@Composable
//fun MainContent(screen: Screen, modifier: Modifier = Modifier) {
//    when (screen) {
//        is AdminScreen.Activities -> HomeScreen(modifier)
//        is AdminScreen.Chat -> SearchScreen(modifier)
//        is AdminScreen.Projects -> ProfileScreen(modifier)
//        is AdminScreen.Assignment -> ProfileScreen(modifier)
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MemberTopAppBar(scope:CoroutineScope){
//    TopAppBar(
//        colors = topAppBarColors(
//            containerColor = Color.Transparent
//        ),
//        title = {
//            Text(
//                "Asme",
//                textAlign = TextAlign.Center,
//                modifier = Modifier.fillMaxWidth(),
//                color = PrimaryColor
//            )
//        },
//        navigationIcon = {
//            IconButton(onClick = {
//
//            }) {
//                Icon(
//                    painter = painterResource(id = R.drawable.menu),
//                    contentDescription = "Menu",
//                    modifier = Modifier
//                        .size(30.dp, 30.dp),
//                    tint = PrimaryColor,
//                )
//            }
//        },
//        actions = {
//            IconButton(
//                onClick = {
//
//                }
//            ) {
//                Icon(painter = painterResource(id = R.drawable.member), contentDescription = "Search")
//            }
//        }
//    )
//}
//
//
//
//@Composable
//fun HomeScreen(modifier: Modifier = Modifier) {
//    Text(
//        text = "Home Screen",
//        modifier = modifier.padding(16.dp)
//    )
//}
//
//@Composable
//fun SearchScreen(modifier: Modifier = Modifier) {
//    Text(
//        text = "Search Screen",
//        modifier = modifier.padding(16.dp)
//    )
//}
//
//@Composable
//fun ProfileScreen(modifier: Modifier = Modifier) {
//    Text(
//        text = "Profile Screen",
//        modifier = modifier.padding(16.dp)
//    )
//}
//@Composable
//fun navigationBarItemColors(): NavigationBarItemColors {
//    return NavigationBarItemDefaults.colors(
//        indicatorColor = BottomNavBarIndicator,
//        selectedIconColor = BottomNavBarIconText,
//        unselectedIconColor = BottomNavBarIconText,
//        selectedTextColor = BottomNavBarIconText,
//        unselectedTextColor = BottomNavBarIconText
//    )
//}
