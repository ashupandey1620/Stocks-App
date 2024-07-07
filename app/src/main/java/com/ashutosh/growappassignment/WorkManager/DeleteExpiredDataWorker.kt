package com.ashutosh.growappassignment.WorkManager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.ashutosh.growappassignment.Data.StockDatabase
import java.util.Calendar

class DeleteExpiredDataWorker(appContext: Context , workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -3)
        val expirationLimit = calendar.time

//        val database = StockDatabase.database
//        val dao = database.yourDao()
//        dao.deleteExpiredData(expirationLimit)

        return Result.success()
    }
}
