package com.pocraft.gassai.ui.team.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pocraft.gassai.model.Team
import com.pocraft.gassai.model.dummyTeamList

class TeamViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    val text: LiveData<String> = _text

    private val _teams = MutableLiveData<List<Team>>().apply {
        value = dummyTeamList
    }
    val teams: LiveData<List<Team>> = _teams
}