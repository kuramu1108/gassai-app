package com.pocraft.gassai.ui.schedule.viewmodel

import androidx.lifecycle.*
import com.pocraft.gassai.db.SessionRepository
import com.pocraft.gassai.model.*
import com.pocraft.gassai.ui.schedule.state.BottomSheetState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

@HiltViewModel
class SessionViewModel @Inject constructor(
    private val sessionRepository: SessionRepository
) : ViewModel() {
    private val venues = MutableStateFlow(dummyVenueList)
    private val sessions = MutableStateFlow<List<SessionWithTeam>>(listOf())
    private val selectedVenue = MutableStateFlow<Venue>(Venue(0, ""))
    private val bottomSheetState = MutableStateFlow(BottomSheetState.EXPANDED)

    data class ViewState(
        val venues: List<Venue> = emptyList(),
        val sessions: List<SessionWithTeam> = emptyList(),
        val selectedVenue: Venue = Venue(0, ""),
        val bottomSheetState: BottomSheetState = BottomSheetState.EXPANDED
    )

    private val _state = MutableStateFlow<ViewState>(ViewState())
    val state: StateFlow<ViewState> = _state

    fun venueSelected(venue: Venue) {
        selectedVenue.value = venue
        if (bottomSheetState.value!! == BottomSheetState.COLLAPSED) {
            bottomSheetState.value = bottomSheetState.value!!.toggleState()
        }
    }

    fun toggleFavorite(session: Session) {
        viewModelScope.launch {
            sessionRepository.toggleFavorite(session)
        }
    }

    fun setBottomSheetState(state: BottomSheetState) {
        bottomSheetState.value = state
    }

    fun viewBackDrop() {
        bottomSheetState.value = bottomSheetState.value!!.toggleState()
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
                        sessions.value = it
                    }
            }

            combine(
                venues,
                sessions,
                selectedVenue,
                bottomSheetState
            ) { venues, sessions, venue, bottomSheetState ->
                val selectedVenue = if (venue.name == "") {
                    venues[0]
                } else {
                    venue
                }
                ViewState(
                    venues = venues,
                    sessions = sessions,
                    selectedVenue = selectedVenue,
                    bottomSheetState = bottomSheetState
                )
            }.collect {
                _state.value = it
            }
        }
    }
}