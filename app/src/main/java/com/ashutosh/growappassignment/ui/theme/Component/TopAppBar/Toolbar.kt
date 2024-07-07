package com.ashutosh.growappassignment.ui.theme.Component.TopAppBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashutosh.growappassignment.ui.theme.GrowAppAssignmentTheme


@Composable
fun Toolbar(
    str:String
) {
          val context = LocalContext.current

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.White),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    textAlign = TextAlign.Start ,
                    fontSize = 22.sp ,
                    lineHeight = 22.sp ,
                    text = str ,
                    color = Color.Black ,
                    fontWeight = FontWeight.Medium
                )
            }

}


@Preview()
@Composable
fun GoalScreenPreview() {
GrowAppAssignmentTheme {
    Toolbar(str = "Stocks App")
}
}

