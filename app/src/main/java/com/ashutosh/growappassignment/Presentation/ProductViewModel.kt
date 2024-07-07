package com.ashutosh.growappassignment.Presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ashutosh.growappassignment.Data.Repository
import com.ashutosh.growappassignment.NetworkModule.Model.CompanyOverView.CompanyOverViewResponse
import com.ashutosh.growappassignment.NetworkModule.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow
import com.ashutosh.growappassignment.Util.Constants
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.ashutosh.growappassignment.Data.CompanyOverView.CompanyOverViewD
import com.ashutosh.growappassignment.Data.TicketSearch.TicketSearchD
import com.ashutosh.growappassignment.Data.TopGainer.TopGainerD
import com.ashutosh.growappassignment.StockApp
import com.ashutosh.growappassignment.ui.theme.Theme.MainEvent
import com.ashutosh.growappassignment.ui.theme.Theme.MainState
import java.util.Calendar
import java.util.Date


@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    var appState by mutableStateOf(MainState())

    private val cODao = StockApp.database.companyOverViewDao()

    var symbol by mutableStateOf("")

    private val _companyOverViewResult = MutableStateFlow<NetworkResult<CompanyOverViewResponse>>(NetworkResult.Loading)
    val companyOverViewResult: StateFlow<NetworkResult<CompanyOverViewResponse>> = _companyOverViewResult

    fun companyOverView(ticker: String?) {
        val function = "OVERVIEW"
        viewModelScope.launch {
            repository.companyOverView(function,ticker.toString(),Constants.API_KEY)
                .onStart {
                    _companyOverViewResult.value = NetworkResult.Loading
                }
                .catch { e ->
                    _companyOverViewResult.value = NetworkResult.Error(e.message ?: "Unknown error")
                }
                .collect { result ->
                    _companyOverViewResult.value =  result

                    val calendar: Calendar = Calendar.getInstance()
                    calendar.add(Calendar.DAY_OF_YEAR , -3)
                    val expirationLimit: Date = calendar.getTime()

                    if (result is NetworkResult.Success) {
                        result.data?.let { response ->

                           val data =  CompanyOverViewD(
                                response.Symbol,
                                response.MarketCapitalization,
                                response.Name,
                                response.`52WeekHigh`,
                                response.`52WeekLow`,
                                response.AnalystTargetPrice,
                                response.AssetType,
                                response.Beta,
                                response.DividendYield,
                                response.ProfitMargin,
                                response.PERatio,
                                response.Sector,
                                response.Industry,
                                expirationLimit.toString()
                            )

                            insertOrUpdateCompanyOverViewInDatabase(data)


                        }
                    }
                }
        }
    }


    private suspend fun insertOrUpdateCompanyOverViewInDatabase(cO:CompanyOverViewD) {
        Log.d("Company OverView are Inserted and Updated","---------Done--------")
        cODao.insertCompanyOverView(cO)
    }



    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.UpdateAppTheme -> {
                viewModelScope.launch {
                    appState = appState.copy(theme = event.theme)
                }
            }
        }
    }
}