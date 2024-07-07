package com.ashutosh.growappassignment.ui.theme.Component.DockedSearchBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ashutosh.growappassignment.Presentation.ExploreViewModel
import com.ashutosh.growappassignment.Presentation.ProductViewModel
import com.ashutosh.growappassignment.R
import com.ashutosh.growappassignment.ui.theme.Component.CardLayout.CardLayout
import com.ashutosh.growappassignment.ui.theme.GrowAppAssignmentTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DockedSearchBar(str:String) {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    val searchHistory = listOf("Android", "Kotlin", "Compose", "Material Design", "GPT-4")

//    val ticketSearch = listOf("Microsoft", "Amazon", "MicoWare", "Tesla", "Netflix")


    val exploreViewModel: ExploreViewModel = hiltViewModel()

    val ticketSearch = exploreViewModel.getSearchesFromNetwork.observeAsState()


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colorScheme.background),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {

        if(!active) {
            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(22.dp) ,
                textAlign = TextAlign.Start ,
                fontSize = 14.sp ,
                lineHeight = 22.sp ,
                text = str ,
                color = MaterialTheme.colorScheme.onPrimary ,
                fontWeight = FontWeight.Medium
            )
        }

        SearchBar(
            colors = SearchBarDefaults.colors(containerColor = MaterialTheme.colorScheme.primary,
                dividerColor = Color.LightGray
                ),
            modifier = Modifier.padding(5.dp),
            query = query ,
            onQueryChange = { query = it
                if(query.isNotEmpty()) {
//                    exploreViewModel.ticketSearch(query)
                }
                            } ,
            onSearch = { newQuery ->
                println("Performing search on query: $newQuery")
            } ,
            active = active ,
            onActiveChange = { active = it } ,
            placeholder = {
                Text(text = "Search",
                    color = MaterialTheme.colorScheme.onPrimary)
            } ,
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Search , contentDescription = "Search")
            } ,
            trailingIcon = {
                Row {
                    if (active) {
                        IconButton(
                            onClick = { if (query.isNotEmpty()) query = "" else active = false }
                        ) {
                            Icon(imageVector = Icons.Filled.Close , contentDescription = "Close")
                        }
                    }
                }
            }
        ) {
            if (!query.isNotEmpty()) {
                searchHistory.takeLast(4).forEach { item ->
                    ListItem(
                        modifier = Modifier.clickable { query = item } ,
                        headlineContent = { Text(text = item) } ,
                        leadingContent = {
                            Icon(
                                painter = painterResource(R.drawable.ic_history) ,
                                contentDescription = null
                            )
                        },

                    )
                }
            }
            else {
                LazyColumn {
                    ticketSearch?.let {
                        items(ticketSearch.value!!.size) { item ->
                            ListItem(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { /* Handle click, e.g., update query */ } ,
                                headlineContent = {
                                    Text(
                                        text = ticketSearch.value!!.get(item).name.toString() ,
                                        color = MaterialTheme.colorScheme.onPrimary
                                    )
                                })

                        }
                    }
                }
            }
            }
        }

}

@OptIn(ExperimentalMaterial3Api::class , ExperimentalLayoutApi::class)
@Composable
fun ChipSelection(){
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Start,
        verticalArrangement = Arrangement.SpaceBetween

    ) {

        FilterChip(selected = false , onClick = { /*TODO*/ } , label = {
            Text(
                modifier = Modifier
                    .wrapContentSize() ,
                textAlign = TextAlign.Start ,
                fontSize = 10.sp ,
                lineHeight = 12.sp ,
                text = "All"  ,
                color = Color(0xFFbc805f) ,
                fontWeight = FontWeight.Bold ,
            )
        } ,
            shape = RoundedCornerShape(30.dp) ,
            colors = FilterChipDefaults.filterChipColors(
                containerColor = Color(
                    0xFFebd2c3
                )
            ) ,
            border = FilterChipDefaults.filterChipBorder(
                borderColor = Color(
                    0xFFebd2c3
                )
            ) ,
            modifier = Modifier.padding(start = 5.dp)
        )

        FilterChip(selected = false , onClick = { /*TODO*/ } , label = {
            Text(
                modifier = Modifier
                    .wrapContentSize() ,
                textAlign = TextAlign.Start ,
                fontSize = 10.sp ,
                lineHeight = 12.sp ,
                text = "Stocks" ,
                color = Color(0xFFbc805f) ,
                fontWeight = FontWeight.Bold ,
            )
        } ,
            shape = RoundedCornerShape(30.dp) ,
            colors = FilterChipDefaults.filterChipColors(
                containerColor = Color(
                    0xFFebd2c3
                )
            ) ,
            border = FilterChipDefaults.filterChipBorder(
                borderColor = Color(
                    0xFFebd2c3
                )
            ) ,
            modifier = Modifier.padding(start = 5.dp)
        )


        FilterChip(selected = false , onClick = { /*TODO*/ } , label = {
            Text(
                modifier = Modifier
                    .wrapContentSize() ,
                textAlign = TextAlign.Start ,
                fontSize = 10.sp ,
                lineHeight = 12.sp ,
                text = "etfs" ,
                color = Color(0xFFbc805f) ,
                fontWeight = FontWeight.Bold ,
            )
        } ,
            shape = RoundedCornerShape(30.dp) ,
            colors = FilterChipDefaults.filterChipColors(
                containerColor = Color(
                    0xFFebd2c3
                )
            ) ,
            border = FilterChipDefaults.filterChipBorder(
                borderColor = Color(
                    0xFFebd2c3
                )
            ) ,
            modifier = Modifier.padding(start = 5.dp)
        )
    }

}


@Preview()
@Composable
fun SearchBarPreview() {
    GrowAppAssignmentTheme {
        DockedSearchBar("Detail Screen")
    }
}
