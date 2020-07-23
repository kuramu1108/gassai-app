package com.pocraft.gassai.ui.team.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.pocraft.gassai.db.TeamRepository
import com.pocraft.gassai.model.Team
import com.pocraft.gassai.model.dummyTeamList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TeamViewModel @ViewModelInject constructor(
    private val teamRepository: TeamRepository
) : ViewModel() {
    private val _teams = teamRepository.teams().asLiveData(viewModelScope.coroutineContext)
    val teams: LiveData<List<Team>> = _teams

    fun saveTeams() {
        viewModelScope.launch {
            if (teamRepository.isEmpty()) {
                teamRepository.save(dummyTeamList)
            }
        }
    }

    init {
        viewModelScope.launch {
            launch {

            }
        }
    }
}