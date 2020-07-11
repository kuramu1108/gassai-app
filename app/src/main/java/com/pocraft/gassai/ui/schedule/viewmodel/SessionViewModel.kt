package com.pocraft.gassai.ui.schedule.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.pocraft.gassai.model.Session
import com.pocraft.gassai.model.Venue
import com.pocraft.gassai.model.dummySessionDay1
import com.pocraft.gassai.model.dummyVenueList
import com.pocraft.gassai.ui.schedule.state.BottomSheetState

class SessionViewModel : ViewModel() {
    private val _venueList = MutableLiveData<List<Venue>>().apply {
        value = dummyVenueList
    }
    val venueList: LiveData<List<Venue>> = _venueList

    private val _sessionList = MutableLiveData<List<Session>>().apply {
        value = dummySessionDay1
    }

    val sessionList: LiveData<List<Session>> = _sessionList

    private val _selectedVenue = MutableLiveData<String>()

    val selectedVenue: LiveData<String> = _selectedVenue

    private val _bottomSheetState = MutableLiveData(BottomSheetState.EXPANDED)

    val bottomSheetState: LiveData<BottomSheetState> = _bottomSheetState

    fun venueSelected(index: Int) {
        _selectedVenue.value = venueList.value!![index].name
        if (bottomSheetState.value!! == BottomSheetState.COLLAPSED) {
            _bottomSheetState.value = bottomSheetState.value!!.toggleState()
        }
    }

    fun setBottomSheetState(state: BottomSheetState) {
        _bottomSheetState.value = state
    }

    fun viewBackDrop() {
        _bottomSheetState.value = bottomSheetState.value!!.toggleState()
    }
}