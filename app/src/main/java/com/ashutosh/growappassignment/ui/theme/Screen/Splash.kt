package com.ashutosh.growappassignment.ui.theme.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ashutosh.growappassignment.Navigation.Routes
import com.ashutosh.growappassignment.Presentation.ExploreViewModel
import com.ashutosh.growappassignment.R
import com.ashutosh.growappassignment.ui.theme.Theme.MainState
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Splash(navController: NavHostController , appState: MainState) {

    val exploreViewModel: ExploreViewModel = hiltViewModel()

    LaunchedEffect(key1 = true) {
        exploreViewModel.getTopGainAndLose()
        delay(500)
        navController.popBackStack()
        navController.navigate(Routes.MainGraph.name)
    }


    Scaffold(modifier = Modifier
        .fillMaxSize(),
        content = {

            Column(
                modifier = Modifier
                    .fillMaxSize() ,
                verticalArrangement = Arrangement.Center ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.in_stock) ,
                    contentDescription = null ,
                    contentScale = ContentScale.Fit ,
                    modifier = Modifier
                        .size(100.dp)
                )


            }
        }
    )
}