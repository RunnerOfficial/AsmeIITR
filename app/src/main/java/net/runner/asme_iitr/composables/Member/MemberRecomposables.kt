package net.runner.asme_iitr.composables.Member

import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import net.runner.asme_iitr.ui.theme.BottomNavBarIconText
import net.runner.asme_iitr.ui.theme.BottomNavBarIndicator


@Composable
fun navigationBarItemColors(): NavigationBarItemColors {
    return NavigationBarItemDefaults.colors(
        indicatorColor = BottomNavBarIndicator,
        selectedIconColor = BottomNavBarIconText,
        unselectedIconColor = BottomNavBarIconText,
        selectedTextColor = BottomNavBarIconText,
        unselectedTextColor = BottomNavBarIconText
    )
}
