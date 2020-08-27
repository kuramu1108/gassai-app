package com.pocraft.gassai.ui.team.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.pocraft.gassai.db.TeamRepository
import com.pocraft.gassai.model.Team
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class TeamViewModel @ViewModelInject constructor(
    private val teamRepository: TeamRepository
) : ViewModel() {
    private val teams2 = MutableStateFlow<List<Team>>(emptyList())
    private val selectedRegion = MutableStateFlow("")

    data class ViewState(
        val teams: List<Team> = emptyList(),
        val selectedRegion: String = ""
    )

    private val _state = MutableStateFlow(ViewState())
    val state: StateFlow<ViewState> = _state

    private val _teams = MutableLiveData<List<Team>>().apply {
        value = emptyList()
    }
    val teams: LiveData<List<Team>> = _teams.distinctUntilChanged()

    fun saveTeams() {
//        viewModelScope.launch {
//            if (teamRepository.isEmpty()) {
//                teamRepository.save(dummyTeamList)
//            }
//        }
    }

    init {
        viewModelScope.launch {
            launch {
                if (teamRepository.isEmpty()) {
                    teamRepository.syncRemote()
                }
            }

            launch {
                teamRepository.teams().collect {
//                    _teams.value = it
                    teams2.value = it
                }
            }

            combine(
                teams2,
                selectedRegion
            ) { teams2, selectedRegion ->
                ViewState(
                    teams = teams2,
                    selectedRegion = selectedRegion
                )
            }.collect {
                _state.value = it
            }
        }
    }
}