package com.pocraft.gassai.ui.team

import android.os.Bundle
import android.view.View
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import com.pocraft.gassai.R
import com.pocraft.gassai.databinding.FragmentTeamBinding
import com.pocraft.gassai.ui.team.adapter.TeamRVAdapter
import com.pocraft.gassai.ui.team.viewmodel.TeamViewModel
import com.pocraft.gassai.utility.doOnApplyWindowInsets
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TeamFragment : Fragment(R.layout.fragment_team) {

    private val teamViewModel by viewModels<TeamViewModel>()

    private var _binding: FragmentTeamBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTeamBinding.bind(view)
        binding.teamRecyclerview.doOnApplyWindowInsets { view, windowInsets ->
            view.updatePadding(
                bottom = windowInsets.systemWindowInsetBottom
            )
        }
        val adapter = TeamRVAdapter()
        binding.teamRecyclerview.adapter = adapter
//        teamViewModel.teams.observe(viewLifecycleOwner) { teams ->
//            adapter.update(teams)
//        }
//        teamViewModel.saveTeams()

        lifecycleScope.launch {
            teamViewModel.state.collect {
                adapter.update(it.teams)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}