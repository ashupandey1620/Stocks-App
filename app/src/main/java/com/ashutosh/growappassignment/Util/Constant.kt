package com.ashutosh.growappassignment.Util

import com.ashutosh.growappassignment.NetworkModule.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.io.IOException


fun<T> result(call:suspend () -> Response<T>):Flow<NetworkResult<T>> = flow {
    emit(NetworkResult.Loading)
    try{
        val c = call()
        c.let {
            if (c.isSuccessful){
                emit(NetworkResult.Success(it.body()))
            } else {
                c.errorBody()?.let { error ->
                    error.close()
                    emit(NetworkResult.Error(error.toString()))
                }
            }
        }
    }catch (e: IOException) {
        NetworkResult.NetworkError
    } catch (t:Throwable){
        t.printStackTrace()
        emit(NetworkResult.Error(t.message.toString()))
    }

}