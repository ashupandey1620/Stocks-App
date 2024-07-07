package com.ashutosh.growappassignment.NetworkModule



sealed class NetworkResult<out T> {
    object Loading : NetworkResult<Nothing>()
    object NetworkError : NetworkResult<Nothing>()
    data class Success<out R>(val data: R?) : NetworkResult<R>()
    data class Error(val errorMessage: String) : NetworkResult<Nothing>()
}
