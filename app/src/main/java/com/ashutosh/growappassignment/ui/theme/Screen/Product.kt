package com.ashutosh.growappassignment.ui.theme.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ashutosh.growappassignment.NetworkModule.Model.CompanyOverView.CompanyOverViewResponse
import com.ashutosh.growappassignment.NetworkModule.NetworkResult
import com.ashutosh.growappassignment.Presentation.ProductViewModel
import com.ashutosh.growappassignment.R
import com.ashutosh.growappassignment.ui.theme.Component.DockedSearchBar.DockedSearchBar
import com.ashutosh.growappassignment.ui.theme.Component.GraphSection
import com.ashutosh.growappassignment.ui.theme.GrowAppAssignmentTheme
import com.ashutosh.growappassignment.ui.theme.Theme.MainState


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Product(
    navController: NavHostController ,
    ticker: String? ,
    appState: MainState
) {

    val productViewModel: ProductViewModel = hiltViewModel()


    LaunchedEffect(ticker) {
        ticker?.let {
            productViewModel.companyOverView(it)
        }
    }

    val companyOverViewState by productViewModel.companyOverViewResult.collectAsState()

    // Use when to handle different states
    when (companyOverViewState) {
        is NetworkResult.Loading -> {

            LoadingScreen()
        }
        is NetworkResult.Success -> {
            val data = (companyOverViewState as NetworkResult.Success<CompanyOverViewResponse>).data

            CompanyOverViewContent(data,ticker)
        }
        is NetworkResult.Error -> {
            val message = (companyOverViewState as NetworkResult.Error).errorMessage

            ErrorScreen(message)
        }

        NetworkResult.NetworkError -> NetworkErrorScreen()
    }


}

@Composable
fun ErrorScreen(message: String) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie3))
    val progress by animateLottieCompositionAsState(composition = composition, restartOnPlay = true,
        iterations = LottieConstants.IterateForever)


    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center)
    {

        LottieAnimation(
            modifier = Modifier.size(200.dp),
            composition = composition,
            progress = {progress})

    }
}

@Composable
fun NetworkErrorScreen() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie1))
    val progress by animateLottieCompositionAsState(composition = composition, restartOnPlay = true,
        iterations = LottieConstants.IterateForever)


    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center)
    {

        LottieAnimation(
            modifier = Modifier.size(200.dp),
            composition = composition,
            progress = {progress})

    }
}

@Composable
fun LoadingScreen() {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie2))
    val progress by animateLottieCompositionAsState(composition = composition, restartOnPlay = true,
        iterations = LottieConstants.IterateForever)


    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center)
    {

        LottieAnimation(
            modifier = Modifier.size(200.dp),
            composition = composition,
            progress = {progress})

    }
}

@OptIn(ExperimentalMaterial3Api::class , ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CompanyOverViewContent(data: CompanyOverViewResponse? , ticker: String?) {


    if (data == null) {
        Text(text = "No Data Available")
        return
    }

    Scaffold(modifier = Modifier.fillMaxSize() ,
        topBar = {
            DockedSearchBar(str = "Detail Screen")
        } ,
        bottomBar = {

        },
        content = {


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .verticalScroll(rememberScrollState()) ,
                verticalArrangement = Arrangement.Top ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                )

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                    horizontalArrangement = Arrangement.SpaceBetween)
                {
                    Row(modifier = Modifier
                        .wrapContentWidth()
                        .fillMaxHeight())
                    {
                        Row(modifier = Modifier
                            .wrapContentWidth()
                            .fillMaxHeight())
                        {

                            Box(modifier = Modifier
                                .size(70.dp)
                                .padding(8.dp)
                                .border(1.dp , Color.LightGray , CircleShape),
                                contentAlignment = Alignment.Center) {
                                Image(
                                    painter = painterResource(id = R.drawable.amazon) ,
                                    contentDescription = null ,
                                    modifier = Modifier
                                        .size(70.dp)
                                        .padding(15.dp)
                                    ,
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }

                        Column(modifier = Modifier
                            .padding(vertical = 7.dp)
                            .wrapContentWidth()
                            .fillMaxHeight(),
                            verticalArrangement = Arrangement.SpaceBetween)
                        {
                            Text(
                                modifier = Modifier
                                    .wrapContentWidth() ,
                                textAlign = TextAlign.Start ,
                                fontSize = 15.sp ,
                                lineHeight = 15.sp ,
                                text = if(data!!.Name.isNotEmpty()) data!!.Name else "N/A" ,
                                color = MaterialTheme.colorScheme.onPrimary ,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                modifier = Modifier
                                    .wrapContentWidth() ,
                                textAlign = TextAlign.Start ,
                                fontSize = 14.sp ,
                                lineHeight = 14.sp ,
                                text = if(data!!.AssetType.isNotEmpty()) data!!.AssetType else "N/A" ,
                                color = MaterialTheme.colorScheme.onPrimary ,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                modifier = Modifier
                                    .wrapContentWidth() ,
                                textAlign = TextAlign.Start ,
                                fontSize = 14.sp ,
                                lineHeight = 14.sp ,
                                text = ticker.toString() ,
                                color = MaterialTheme.colorScheme.onSecondary ,
                                fontWeight = FontWeight.Medium
                            )

                        }

                    }

                    Column(modifier = Modifier
                        .wrapContentWidth()
                        .fillMaxHeight()
                        .padding(end = 10.dp)
                        ,
                        verticalArrangement = Arrangement.Center)
                    {

                        Row(modifier = Modifier
                            .wrapContentSize())
                        {

                            Text(
                                modifier = Modifier
                                    .wrapContentWidth() ,
                                textAlign = TextAlign.Start ,
                                fontSize = 14.sp ,
                                lineHeight = 14.sp ,
                                text = if(data!!.AnalystTargetPrice.isNotEmpty()) data!!.AnalystTargetPrice else "N/A" ,
                                color = MaterialTheme.colorScheme.onPrimary ,
                                fontWeight = FontWeight.Medium
                            )




                        }

                        Row(modifier = Modifier
                            .wrapContentSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start)
                        {


                            Text(
                                modifier = Modifier
                                    .wrapContentWidth() ,
                                textAlign = TextAlign.Start ,
                                fontSize = 12.sp ,
                                lineHeight = 12.sp ,
                                text = "+0.41%" ,
                                color = Color.Green,
                                fontWeight = FontWeight.Medium
                            )

                            Icon(
                                painter = painterResource(R.drawable.ic_up) ,
                                contentDescription = null,
                                tint = Color(0xFF00f700),
                                modifier = Modifier.size(30.dp)
                            )

                        }
                    }
                }


                Column(modifier = Modifier
                    .padding(10.dp)
                    .border(1.dp , Color.LightGray , RoundedCornerShape(5.dp))) {
                    GraphSection()
                }


                Column(modifier = Modifier
                    .padding(10.dp)
                    .border(1.dp , Color.LightGray , RoundedCornerShape(5.dp))) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 3.dp) ,
                            textAlign = TextAlign.Start ,
                            fontSize = 12.sp ,
                            lineHeight = 16.sp ,
                            text =  if(data!!.Name.isNotEmpty()) "About ${data!!.Name}" else "N/A"  ,
                            color = MaterialTheme.colorScheme.onPrimary ,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.LightGray)){

                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 1.dp) ,
                            textAlign = TextAlign.Start ,
                            fontSize = 10.sp ,
                            lineHeight = 13.sp ,
                            text = if(data!!.Description.isNotEmpty()) data!!.Description else "N/A" ,
                            color = MaterialTheme.colorScheme.onSecondary ,
                            fontWeight = FontWeight.Medium
                        )
                    }

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
                                text = if(data!!.Industry.isNotEmpty()) "Industry: ${data!!.Industry}" else "N/A"  ,
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
                                text = if(data!!.Sector.isNotEmpty()) "Sector: ${data!!.Sector}" else "N/A"  ,
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


                    Row(modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {

                        Column(modifier = Modifier
                            .wrapContentSize()
                            .padding(start = 5.dp)
                        )
                        {

                            Text(
                                modifier = Modifier
                                    .wrapContentSize()
                                ,
                                textAlign = TextAlign.Start ,
                                fontSize = 10.sp ,
                                lineHeight = 12.sp ,
                                text = "52-Week Low" ,
                                color = MaterialTheme.colorScheme.onSecondary,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                modifier = Modifier
                                    .wrapContentSize()
                                ,
                                textAlign = TextAlign.Start ,
                                fontSize = 10.sp ,
                                lineHeight = 12.sp ,
                                text = if(data!!.`52WeekLow`.isNotEmpty()) "$ ${data!!.`52WeekLow`}" else "N/A"  ,
                                color = MaterialTheme.colorScheme.onPrimary ,
                                fontWeight = FontWeight.Bold,
                            )



                        }

                        Column(modifier = Modifier
                            .width(160.dp),
                            verticalArrangement = Arrangement.Top
                        )
                        {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                ,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp ,
                                lineHeight = 9.sp ,
                                text = if(data!!.AnalystTargetPrice.isNotEmpty()) "Current Price: $ ${data!!.AnalystTargetPrice}" else "N/A"   ,
                                color = MaterialTheme.colorScheme.onPrimary ,
                                fontWeight = FontWeight.Bold,
                            )

                            Row (modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center){

                                Icon(
                                    painter = painterResource(R.drawable.ic_down) ,
                                    contentDescription = null ,
                                    tint = MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier
                                        .width(30.dp)
                                        .wrapContentHeight()
                                )
                            }

                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .height(4.dp)
                                .background(MaterialTheme.colorScheme.onSecondary)) {



                            }



                        }

                        Column(modifier =
                        Modifier
                            .padding(end = 5.dp)
                            .wrapContentSize()
                        )
                        {

                            Text(
                                modifier = Modifier
                                    .wrapContentSize()
                                ,
                                textAlign = TextAlign.Start ,
                                fontSize = 10.sp ,
                                lineHeight = 12.sp ,
                                text = "52-Week High" ,
                                color = MaterialTheme.colorScheme.onSecondary ,
                                fontWeight = FontWeight.Bold,
                            )

                            Text(
                                modifier = Modifier
                                    .wrapContentSize()
                                ,
                                textAlign = TextAlign.Start ,
                                fontSize = 10.sp ,
                                lineHeight = 12.sp ,
                                text = if(data!!.`52WeekHigh`.isNotEmpty()) "$ ${data!!.`52WeekLow`}" else "N/A",
                                        color = MaterialTheme.colorScheme.onPrimary ,
                                fontWeight = FontWeight.Bold,
                            )



                        }



                    }


                    Row(modifier = Modifier
                        .padding(5.dp)
                        .padding(vertical = 7.dp)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {

                        AllValue(str = "Market Cap" , value = "$ ${data.MarketCapitalization}" )
                        AllValue(str = "P/E Ratio" , value = data.PERatio)
                        AllValue(str = "Beta" , value = data.Beta)
                        AllValue(str = "Dividend Yield" , value = data.DividendYield)
                        AllValue(str = "Profit Margin" , value = data.ProfitMargin)



                    }

                }

            }

        }
    )
}


@Composable
fun AllValue(str:String,value:String){

    Column(modifier =
    Modifier
        .padding(end = 5.dp)
        .wrapContentSize()
    )
    {

        Text(
            modifier = Modifier
                .wrapContentSize()
            ,
            textAlign = TextAlign.Start ,
            fontSize = 10.sp ,
            lineHeight = 12.sp ,
            text = str ,
            color = MaterialTheme.colorScheme.onSecondary ,
            fontWeight = FontWeight.Bold,
        )

        Text(
            modifier = Modifier
                .wrapContentSize()
            ,
            textAlign = TextAlign.Start ,
            fontSize = 10.sp ,
            lineHeight = 12.sp ,
            text = value ,
            color = MaterialTheme.colorScheme.onPrimary,
            fontWeight = FontWeight.Bold,
        )



    }

}



@Preview()
@Composable
fun ProductPreview() {
    GrowAppAssignmentTheme{
//        Product()
    }
}