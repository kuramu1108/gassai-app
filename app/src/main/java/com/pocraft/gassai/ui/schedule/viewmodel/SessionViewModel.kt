package com.pocraft.gassai.ui.schedule.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.pocraft.gassai.db.SessionRepository
import com.pocraft.gassai.model.*
import com.pocraft.gassai.ui.schedule.state.BottomSheetState
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class SessionViewModel @ViewModelInject constructor(
    private val sessionRepository: SessionRepository
) : ViewModel() {
    private val _venueList = MutableLiveData<List<Venue>>().apply {
        value = dummyVenueList
    }
    val venueList: LiveData<List<Venue>> = _venueList

    private val _sessionList = MutableLiveData<List<SessionWithTeam>>().apply {
        value = listOf()
    }

    val sessionList: LiveData<List<SessionWithTeam>> = _sessionList

    private val _selectedVenue = MutableLiveData<Venue>()

    val selectedVenue: LiveData<Venue> = _selectedVenue

    private val _bottomSheetState = MutableLiveData(BottomSheetState.EXPANDED)

    val bottomSheetState: LiveData<BottomSheetState> = _bottomSheetState

    fun venueSelected(venue: Venue) {
        _selectedVenue.value = venue
        if (bottomSheetState.value!! == BottomSheetState.COLLAPSED) {
            _bottomSheetState.value = bottomSheetState.value!!.toggleState()
        }
    }

    fun toggleFavorite(session: Session) {
        viewModelScope.launch {
            sessionRepository.toggleFavorite(session)
        }
    }

    fun setBottomSheetState(state: BottomSheetState) {
        _bottomSheetState.value = state
    }

    fun viewBackDrop() {
        _bottomSheetState.value = bottomSheetState.value!!.toggleState()
    }

    fun save() {
        viewModelScope.launch {
            if (sessionRepository.isEmpty()) {
                sessionRepository.save(dummySessionDay1)
            }
        }
    }

    init {
        viewModelScope.launch {
            launch {
                sessionRepository.sessionsWithTeam()
                    .collect {
                        _sessionList.value = it
                    }
            }
        }
    }
}