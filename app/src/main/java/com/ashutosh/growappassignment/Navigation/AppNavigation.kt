package com.ashutosh.growappassignment.Navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.ashutosh.growappassignment.Presentation.ProductViewModel
import com.ashutosh.growappassignment.ui.theme.Screen.Explore
import com.ashutosh.growappassignment.ui.theme.Screen.News
import com.ashutosh.growappassignment.ui.theme.Screen.Product
import com.ashutosh.growappassignment.ui.theme.Screen.ProductDetail
import com.ashutosh.growappassignment.ui.theme.Screen.Splash


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(viewModel: ProductViewModel) {
    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = Routes.Splash.name
    ) {

            composable(Routes.Splash.name) {
                Splash(
                    navController,
                    viewModel.appState
                )
            }

            navigation(
                route = Routes.MainGraph.name, startDestination = Routes.Explore.name
            ) {

                composable(Routes.Explore.name) {
                    Explore(
                        navController,
                        viewModel.appState,
                        onMainEvent = viewModel::onEvent
                    )
                }

                composable("Product/{ticker}", arguments = listOf(
                    navArgument(name = "ticker"){
                        type = NavType.StringType
                    }))
                { data ->
                    Product(
                        navController,
                        data.arguments?.getString("ticker"),
                        viewModel.appState
                    )
                }
                composable(Routes.ProductDetail.name) {
                    ProductDetail(
                        navController,
                        viewModel.appState
                    )
                }
                composable(Routes.News.name) {
                    News(
                        navController,
                        viewModel.appState
                    )
                }

            }
    }
}


val NavHostController.isValidBackStack
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED


