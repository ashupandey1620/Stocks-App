package com.ashutosh.growappassignment.ui.theme.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ashutosh.growappassignment.ui.theme.Component.NavigationDrawerComponent
import com.ashutosh.growappassignment.ui.theme.Component.Tabs.TopGainer
import com.ashutosh.growappassignment.ui.theme.Component.Tabs.TopLoser
import com.ashutosh.growappassignment.ui.theme.Component.Tabs.tabs
import com.ashutosh.growappassignment.ui.theme.Component.TopAppBar.Toolbar
import com.ashutosh.growappassignment.ui.theme.GrowAppAssignmentTheme
import com.ashutosh.growappassignment.ui.theme.Theme.MainEvent
import com.ashutosh.growappassignment.ui.theme.Theme.MainState
import com.ashutosh.growappassignment.ui.theme.Theme.h1TextStyle
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Explore(navController: NavController , appState: MainState,
            onMainEvent: (MainEvent) -> Unit) {


    var selectedIndex by remember {
        mutableStateOf(0)
    }

    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = MaterialTheme.colorScheme.primary) {
                NavigationDrawerComponent(
                    appState,
                    onMainEvent,
                    onClickNews = {
                        scope.launch {
                            drawerState.close()
                        }
                    }
                )
            }
        }) {
        Scaffold(modifier = Modifier.fillMaxSize() ,
        topBar = {
            TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            ),
            title = {
                Text(
                    text = "Stocks App",
                    style = h1TextStyle
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
                        imageVector = Icons.Default.Menu,
                        contentDescription = null
                    )
                }
            })
        } ,
        bottomBar = {


            TabRow(selectedTabIndex = selectedIndex ,
                modifier = Modifier.fillMaxWidth()
                ,
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = Color.Blue ,
                indicator = {} ,
                divider = {}
            ) {

                tabs.forEachIndexed { index , tabData ->


                    if (index == selectedIndex) {
                        Tab(
                            selected = index == selectedIndex ,
                            onClick = { selectedIndex = index } ,
                            text = {
                                Text(
                                    text = tabData.title ,
                                    style = TextStyle(fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold)
                                )
                            } ,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(12.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFffd700)) ,
                            selectedContentColor = MaterialTheme.colorScheme.onPrimary ,
                            unselectedContentColor = MaterialTheme.colorScheme.onSecondary

                        )
                    } else {
                        Tab(
                            selected = index == selectedIndex ,
                            onClick = { selectedIndex = index } ,
                            text = {
                                Text(
                                    text = tabData.title ,
                                    style = TextStyle(fontSize = 14.sp,
                                        fontWeight = FontWeight.Medium)
                                )
                            } ,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(15.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFfbd137)) ,
                            selectedContentColor = Color.Black ,
                            unselectedContentColor = Color.Black

                        )
                    }
                }
            }

        },
        content = {

            if(selectedIndex==0){
                TopGainer(navController)
            }else{
                TopLoser(navController)
            }

        }
    )
    }
}



@Preview()
@Composable
fun ExplorePreview() {
    GrowAppAssignmentTheme{

    }
}
