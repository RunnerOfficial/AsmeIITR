package net.runner.asme_iitr.composables.Member

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import net.runner.asme_iitr.R
import net.runner.asme_iitr.ui.theme.CardBackground

@Composable
fun AssignmentFragment(modifier: Modifier=Modifier){
    LazyColumn(
        modifier = modifier
    ) {
            item {
                AssignmentItem(photo = R.drawable.assignment, name ="assignment 2" , dueDate ="29/06/24" , specificName ="solid" )
            }
        item {
            AssignmentItem(photo = R.drawable.assignment, name ="sdf" , dueDate ="27/05/19"  )
        }
    }

}

@Composable
fun AssignmentItem(photo:Int,name:String,dueDate:String,specificName:String=""){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 2.dp),
        colors = CardDefaults.cardColors(CardBackground)


    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = photo), contentDescription = "status", modifier = Modifier
                .padding(vertical = 10.dp)
                .weight(0.15f)
                .size(45.dp)
            )

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .weight(0.6f)
            ) {

                Text(text = name,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                    .fillMaxWidth(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(text = specificName, textAlign = TextAlign.Left, modifier = Modifier
                    .fillMaxWidth())

            }

            Text(text = dueDate,
                textAlign = TextAlign.Right,
                modifier = Modifier
                    .padding(10.dp)
                    .weight(0.2f)
                    .offset(0.dp,(-10).dp)
                ,
                style = MaterialTheme.typography.titleMedium


            )


        }
    }
}