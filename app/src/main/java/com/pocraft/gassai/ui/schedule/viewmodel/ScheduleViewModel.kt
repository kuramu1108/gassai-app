package com.pocraft.gassai.ui.schedule.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pocraft.gassai.model.dummySchedule

class ScheduleViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is schedule Fragment"
    }
    val text: LiveData<String> = _text

    private val _schedules = MutableLiveData<Array<String>>().apply {
        value = dummySchedule
    }
    val schedules: LiveData<Array<String>> = _schedules
}