package com.ashutosh.growappassignment.ui.theme.Component.CardLayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ashutosh.growappassignment.R
import com.ashutosh.growappassignment.ui.theme.GrowAppAssignmentTheme


@Composable
fun CardLayout(
    icon: Int ,
    name: String ,
    price: String ,
    perc: String ,
    navController: NavController ,
    onClick: () -> Unit
) {


    Column(modifier = Modifier
        .padding(6.dp)
        .border(1.dp , Color.LightGray , RoundedCornerShape(10.dp))
        .clip(RoundedCornerShape(10.dp))
        .background(MaterialTheme.colorScheme.background)
        .clickable {
            onClick()
        }
        .padding(15.dp)
        .width(200.dp)
        .wrapContentHeight()


        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {


        Box(modifier = Modifier
            .wrapContentSize()
            .border(1.dp , Color.LightGray , CircleShape),
            contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = icon) ,
                contentDescription = null ,
                modifier = Modifier
                    .size(55.dp)
                    .padding(10.dp)
                     ,
                contentScale = ContentScale.Crop
            )
        }

        Text(
            maxLines = 1,
            modifier = Modifier
                .padding(top = 10.dp , bottom = 5.dp)
                .wrapContentWidth()
                .wrapContentHeight(),
            textAlign = TextAlign.Center ,
            fontSize = 12.sp ,
            lineHeight = 12.sp ,
            text =  name ,
            color = MaterialTheme.colorScheme.onPrimary ,
            fontWeight = FontWeight.Medium
        )

        Text(
            maxLines = 1,
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            textAlign = TextAlign.Start ,
            fontSize = 14.sp ,
            lineHeight = 16.sp ,
            text = "$ $price" ,
            color = MaterialTheme.colorScheme.onSecondary ,
            fontWeight = FontWeight.Medium
        )

        if(perc[0] != '-') {
            Row (modifier = Modifier
                .padding(bottom = 5.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically){

                Text(
                    maxLines = 1 ,
                    textAlign = TextAlign.Start ,
                    fontSize = 12.sp ,
                    lineHeight = 12.sp ,
                    text = perc ,
                    color = Color(0xFF00f700) ,
                    fontWeight = FontWeight.Light
                )

                Icon(
                    painter = painterResource(R.drawable.ic_up) ,
                    contentDescription = null,
                    tint = Color(0xFF00f700),
                    modifier = Modifier.size(25.dp)
                )
            }
        }
        else {

            Row (modifier = Modifier
                .padding(bottom = 5.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically) {
                Text(
                    maxLines = 1 ,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .wrapContentWidth()
                        .wrapContentHeight() ,
                    textAlign = TextAlign.Start ,
                    fontSize = 12.sp ,
                    lineHeight = 12.sp ,
                    text = perc ,
                    color = Color.Red ,
                    fontWeight = FontWeight.Light
                )
                Icon(
                    painter = painterResource(R.drawable.ic_down) ,
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier.size(25.dp)
                )
            }
        }

    }
}

//
//@Preview()
//@Composable
//fun TeamItemPreview() {
//    GrowAppAssignmentTheme{
//        CardLayout(
//            R.drawable.apple ,
//            "Apple, Inc. (APPL)" ,
//            "177.15",
//            "0.88" ,
////            navController
//        )
//    }
//}
