package net.runner.asme_iitr.composables.Member

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import net.runner.asme_iitr.R
import net.runner.asme_iitr.ui.theme.glassLike
import net.runner.goodvib.GoodVib


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreFragment(onDismiss:(Boolean)->Unit){
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    GoodVib.vib(context,50)

    ModalBottomSheet(
        onDismissRequest = {
            onDismiss(false)
        },
        sheetState = sheetState,
        containerColor = glassLike,
        modifier = Modifier.fillMaxHeight(0.4f)
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 20.dp)
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
              BottomSheetApp(Icon = painterResource(id = R.drawable.activity), name = "Activity") {

              }
            }
        }
    }
}

@Composable
fun BottomSheetApp(Icon:Painter,name:String,onclick:()->Unit){
    Box{
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            IconButton(onClick = onclick) {
                Icon(painter=Icon, contentDescription = "App", tint = Color.Gray)
            }
            Text(text = name, color = Color.LightGray)


        }
    }
}