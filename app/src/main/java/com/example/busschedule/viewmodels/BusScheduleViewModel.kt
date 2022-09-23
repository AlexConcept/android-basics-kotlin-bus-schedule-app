package com.example.busschedule.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.database.schedule.ScheduleDao
import kotlinx.coroutines.flow.Flow

class BusScheduleViewModel (private val ScheduleDao: ScheduleDao) : ViewModel(){
    fun fullSchedule(): Flow<List<Schedule>> = ScheduleDao.getAll()
    fun scheduleForStopName (name: String): Flow<List<Schedule>> = ScheduleDao.getByStop(name)
}

class BusScheduleViewModelFactory(
    private val scheduleDao: ScheduleDao
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusScheduleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BusScheduleViewModel(scheduleDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}