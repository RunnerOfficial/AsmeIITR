package net.runner.asme_iitr.composables.Member

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.runner.asme_iitr.ui.theme.Dateclr
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ActivityFragment(modifier: Modifier = Modifier) {
   Column(
       modifier = modifier.fillMaxSize()
   ) {
       HorizontalCalendar(startDate = LocalDate.now(), endDate = LocalDate.now().plusDays(40) ) {

       }
       LatestMeet()

   }
}
@Composable
fun LatestMeet(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .shadow(elevation = 10.dp)

    ) {
    }
}

@Composable
fun HorizontalCalendar(
    startDate: LocalDate,
    endDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit
) {
    val dates = generateDateRange(startDate, endDate)
    var selectedDate by rememberSaveable { mutableStateOf<LocalDate?>(null) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        items(dates.size) { index ->
            val date = dates[index]
            DateItem(
                date = date,
                isSelected = date == selectedDate,
                onClick = {
                    selectedDate = date
                    onDateSelected(date)
                }
            )
        }
    }
}
@Composable
private fun DateItem(
    date: LocalDate,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) MaterialTheme.colorScheme.onTertiary else Color.LightGray
    val contentColor = if (isSelected) Color.White else Dateclr

    Card(
        modifier = Modifier
            .height(120.dp)
            .width(80.dp)
            .padding(horizontal = 5.dp, vertical = 8.dp)
            .clickable(onClick = onClick,)
            .shadow(elevation = 15.dp, shape = RoundedCornerShape(50.dp))

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
            ,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = date.format(DateTimeFormatter.ofPattern("d")),
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                color = contentColor
            )
        }
    }
}

fun generateDateRange(startDate: LocalDate, endDate: LocalDate): List<LocalDate> {
    val dates = mutableListOf<LocalDate>()
    var date = startDate
    while (date <= endDate) {
        dates.add(date)
        date = date.plusDays(1)
    }
    return dates
}


