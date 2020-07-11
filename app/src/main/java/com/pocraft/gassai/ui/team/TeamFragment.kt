package com.pocraft.gassai.ui.team

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.pocraft.gassai.R
import com.pocraft.gassai.databinding.FragmentTeamBinding
import com.pocraft.gassai.ui.team.adapter.TeamRVAdapter
import com.pocraft.gassai.ui.team.viewmodel.TeamViewModel

class TeamFragment : Fragment(R.layout.fragment_team) {

    private val teamViewModel by viewModels<TeamViewModel>()

    private var _binding: FragmentTeamBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTeamBinding.bind(view)
        teamViewModel.teams.observe(viewLifecycleOwner) { teams ->
            binding.teamRecyclerview.adapter = TeamRVAdapter(teams)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}