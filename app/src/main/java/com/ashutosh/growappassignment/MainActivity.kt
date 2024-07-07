package com.ashutosh.growappassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ashutosh.growappassignment.Navigation.AppNavigation
import com.ashutosh.growappassignment.Presentation.ProductViewModel
import com.ashutosh.growappassignment.ui.theme.GrowAppAssignmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ProductViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GrowAppAssignmentTheme(theme = viewModel.appState.theme) {
                Surface(
                    modifier = Modifier.fillMaxSize() ,
                    color = MaterialTheme.colorScheme.background
                ){
                    AppNavigation(viewModel)
                }
            }
        }
    }
}

