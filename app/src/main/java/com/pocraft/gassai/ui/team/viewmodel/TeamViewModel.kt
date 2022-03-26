package com.pocraft.gassai.ui.team.viewmodel

import androidx.lifecycle.*
import com.pocraft.gassai.db.TeamRepository
import com.pocraft.gassai.model.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val teamRepository: TeamRepository
) : ViewModel() {
    private val teams = MutableStateFlow<List<Team>>(emptyList())
    private val selectedRegion = MutableStateFlow("")

    data class ViewState(
        val teams: List<Team> = emptyList(),
        val selectedRegion: String = ""
    )

    private val _state = MutableStateFlow(ViewState())
    val state: StateFlow<ViewState> = _state

    init {
        viewModelScope.launch {
            launch {
                if (teamRepository.isEmpty()) {
                    teamRepository.syncRemote()
                }
            }

            launch {
                teamRepository.teams().collect {
                    teams.value = it
                }
            }

            combine(
                teams,
                selectedRegion
            ) { teams, selectedRegion ->
                ViewState(
                    teams = teams,
                    selectedRegion = selectedRegion
                )
            }.collect {
                _state.value = it
            }
        }
    }
}