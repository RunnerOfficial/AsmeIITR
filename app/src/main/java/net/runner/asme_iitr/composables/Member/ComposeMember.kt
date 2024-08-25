package net.runner.asme_iitr.composables.Member

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import net.runner.asme_iitr.R
import net.runner.asme_iitr.composables.getBackGroundGradientBrush
import net.runner.asme_iitr.navigation.Drawer
import net.runner.asme_iitr.navigation.Screen
import net.runner.asme_iitr.ui.theme.BgGradient1
import net.runner.asme_iitr.ui.theme.BottomNavBarIndicator
import net.runner.asme_iitr.ui.theme.DarkText
import net.runner.asme_iitr.ui.theme.DrawerColor
import net.runner.asme_iitr.ui.theme.PrimaryColor
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun MemberLogin(){
    Main()
}

@Composable
fun Main() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    val gradientBrush = getBackGroundGradientBrush(screenWidth,screenHeight)

    var currentScreen by remember { mutableStateOf<Screen>(Screen.Activities) }
    var currentDrawer by remember { mutableStateOf<Drawer>(Drawer.Drawer1) }
    var moreselected by rememberSaveable {
        mutableStateOf(false)
    }
    if(moreselected){
        MoreFragment{value->
            moreselected=value
        }
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBrush)
    ){
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = { ShowMemberDrawer(currentDrawer) {selected->
                currentDrawer=selected
                }
            }
        ) {
            Scaffold(
                topBar = {
                    MemberTopAppBar(scope,drawerState)
                },
                bottomBar = {
                    HorizontalDivider(
                        thickness = 0.2.dp,
                        color = DarkText
                    )
                    BottomNavigationBar(currentScreen) { screen,more ->
                        currentScreen = screen
                        if(more){
                            moreselected=true
                        }
                    }
                },
                containerColor = Color.Transparent
            ) { innerPadding ->
                MainContent(currentScreen, modifier = Modifier.padding(innerPadding))
            }
        }
    }

}




@Composable
fun BottomNavigationBar(currentScreen: Screen, onScreenSelected: (Screen,Boolean) -> Unit) {

    NavigationBar (
        containerColor = Color.Transparent,
        contentColor = DarkText,
        tonalElevation = 12.dp,
        windowInsets = WindowInsets(left = 0.dp, right = 0.dp, top = 0.dp, bottom = 0.dp)
    ){
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.activity), contentDescription = "Activities", modifier = Modifier.size(23.dp)) },
            label = { Text("Activities",style = MaterialTheme.typography.labelMedium) },
            selected = currentScreen is Screen.Activities,
            onClick = { onScreenSelected(Screen.Activities,false) },
            colors = navigationBarItemColors()
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.chat), contentDescription = "Chat", modifier = Modifier.size(23.dp))},
            label = { Text("Chat", style = MaterialTheme.typography.labelMedium) },
            selected = currentScreen is Screen.Chat,
            onClick = {onScreenSelected(Screen.Chat,false)},
            colors = navigationBarItemColors()

        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.project), contentDescription = "Projects", modifier = Modifier.size(23.dp)) },
            label = { Text("Projects", style = MaterialTheme.typography.labelMedium )},
            selected = currentScreen is Screen.Projects,
            onClick = { onScreenSelected(Screen.Projects,false)},
            colors = navigationBarItemColors()
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.assignment), contentDescription = "Assignments", modifier = Modifier.size(23.dp)) },
            label = { Text("Assignment", style = MaterialTheme.typography.labelMedium, maxLines = 1, overflow = TextOverflow.Ellipsis)},
            selected = currentScreen is Screen.Assignment,
            onClick = { onScreenSelected(Screen.Assignment,false)},
            colors = navigationBarItemColors()
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.more), contentDescription = "More", modifier = Modifier.size(23.dp)) },
            label = { Text("More", style = MaterialTheme.typography.labelMedium)},
            selected = false,
            onClick = { onScreenSelected(currentScreen,true)},
            colors = navigationBarItemColors()
        )
    }
}
@Composable
fun MainContent(screen: Screen, modifier: Modifier = Modifier) {
    when (screen) {
        is Screen.Activities -> ActivityFragment(modifier)
        is Screen.Chat -> Unit
        is Screen.Projects -> Unit
        is Screen.Assignment -> AssignmentFragment(modifier)
        is Screen.More -> Unit
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemberTopAppBar(scope:CoroutineScope,drawerState:DrawerState){
    TopAppBar(
        colors = topAppBarColors(
            containerColor = Color.Transparent
        ),
        title = {
            Text(
                "ASME",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    drawerState.apply {
                        if (isClosed) open() else close()
                    }
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(30.dp, 30.dp),
                    tint = PrimaryColor,
                )
            }
        },
        actions = {
            IconButton(
                onClick = {

                }
            ) {
                Icon(painter = painterResource(id = R.drawable.member), contentDescription = "Search", modifier = Modifier.size(35.dp))
            }
        }
    )
}
@Composable
fun ShowMemberDrawer(currentDrawer: Drawer,selectedDrawer: (Drawer)->Unit) {
            ModalDrawerSheet (
                drawerShape =  RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp),
                drawerContainerColor = DrawerColor,
                modifier = Modifier.width(300.dp)
            ){
                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    item {
                        DrawerTop(profileImagePainter = painterResource(id = R.drawable.admin), profileName = "Name")
                        HorizontalDivider(color = PrimaryColor, modifier = Modifier.padding(2.dp))
                        DrawerItem(label = "Drawer1",
                            painterResource(id = R.drawable.certificate),currentDrawer is Drawer.Drawer1) {
                            selectedDrawer(Drawer.Drawer1)
                        }
                        DrawerItem(label = "Drawer2",
                            painterResource(id = R.drawable.certificate),currentDrawer is Drawer.Drawer2) {
                            selectedDrawer(Drawer.Drawer2)
                        }
                        DrawerItem(label = "Drawer2",
                            painterResource(id = R.drawable.certificate),currentDrawer is Drawer.Drawer3) {
                            selectedDrawer(Drawer.Drawer3)
                        }

                    }
                }



        }
}
@Composable
fun DrawerNavigation(drawer: Drawer, modifier: Modifier = Modifier) {
    when (drawer) {
        is Drawer.Drawer1 -> Unit
        is Drawer.Drawer2-> Unit
        is Drawer.Drawer3 -> Unit
    }
}
@Composable
fun DrawerItem(label:String,itemIcon: Painter,selected:Boolean,onCLick:()->Unit){
    NavigationDrawerItem(
        label = { Text(text = label, color = BgGradient1) },
        selected = selected,
        onClick = { onCLick() },
        shape = RectangleShape,
        icon = { Icon(painter = itemIcon, contentDescription = "DrawerItem", tint = Color.Black, modifier = Modifier.fillMaxHeight(0.6f)) },
        colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = DrawerColor, selectedContainerColor = BottomNavBarIndicator)
    )
}
@Composable
fun DrawerTop(
    profileImagePainter: Painter,
    profileName: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        IconButton(
            modifier = Modifier
                .size(120.dp)
                .padding(10.dp),
            onClick = { /*TODO: Add your click action here */ }
        ) {
            Icon(
                painter = profileImagePainter,
                contentDescription = "Profile Picture"
            )
        }
        Text(
            text = profileName
        )
    }
}

