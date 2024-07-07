package com.ashutosh.growappassignment.ui.theme.Component.Tabs

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ashutosh.growappassignment.Presentation.ExploreViewModel
import com.ashutosh.growappassignment.R
import com.ashutosh.growappassignment.ui.theme.Component.CardLayout.CardLayout
import com.ashutosh.growappassignment.ui.theme.Component.TopAppBar.Toolbar




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopLoser(navController: NavController) {



    val exploreViewModel: ExploreViewModel = hiltViewModel()
    val ItemsList = exploreViewModel.getTopLoser.observeAsState()




    LaunchedEffect(Unit) {
//        exploreViewModel.getTopGainAndLose()
    }



//    val ItemsList = listOf(
//
//        SupportCardList(
//            R.drawable.apple,
//            "Apple, Inc. (APPL)",
//            "175.15",
//            "3.9"
//        ) ,
//        SupportCardList(
//            R.drawable.microsoft,
//            "Microsoft Cooperation",
//            "421.63",
//            "0.25"
//        ) ,
//        SupportCardList(
//            R.drawable.amazon,
//            "Alphabet Inc. - Class A",
//            "342.21",
//            "1.25"
//        ) ,
//        SupportCardList(
//            R.drawable.tesla,
//            "Tesla Inc, (TSL)",
//            "50001.03",
//            "2.36"
//        ) ,
//        SupportCardList(
//            R.drawable.netflix,
//            "Netflix inc",
//            "App Developer",
//            "Online"
//        ) ,
//        SupportCardList(
//            R.drawable.apple,
//            "Apple inc - (APPl)",
//            "127.65",
//            "7.21"
//        )
//    )



            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                ,
                verticalArrangement = Arrangement.Top ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )

                if (ItemsList.value != null && ItemsList.value!!.isNotEmpty()) {

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2) ,
                        modifier = Modifier
                            .fillMaxSize() ,
                        userScrollEnabled = true ,

                        contentPadding = PaddingValues(
                            start = 12.dp ,
                            top = 16.dp ,
                            end = 12.dp ,
                            bottom = 80.dp
                        ) ,
                        content = {

                            ItemsList?.let {
                                items(ItemsList.value!!.size) { it ->
                                    CardLayout(
                                        ItemsList.value!!.get(it).icon ,
                                        ItemsList.value!!.get(it).ticker ,
                                        ItemsList.value!!.get(it).price ,
                                        ItemsList.value!!.get(it).change_percentage,
                                        navController
                                    ){
                                        navController.navigate("Product"
                                                + "/${ItemsList.value!!.get(it).ticker}"
                                        )
                                    }
                                }
                            }
                        }
                    )
                }

            }




}