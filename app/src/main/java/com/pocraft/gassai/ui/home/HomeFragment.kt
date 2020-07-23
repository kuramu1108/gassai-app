package com.pocraft.gassai.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.pocraft.gassai.R
import com.pocraft.gassai.databinding.FragmentHomeBinding
import com.pocraft.gassai.ui.home.adapter.PostRVAdapter
import com.pocraft.gassai.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel by viewModels<HomeViewModel>()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

//        val navController = findNavController()
//        val activity = activity as AppCompatActivity
//        activity.setSupportActionBar(binding.homeCollapsingBar)
//        val drawer = activity?.findViewById<DrawerLayout>(R.id.drawer_layout)
//        val appBarConfiguration = AppBarConfiguration(navController.graph, drawer)
//        binding.homeCollapsingBar.setupWithNavController(navController, appBarConfiguration)
        val adapter = PostRVAdapter()
        binding.postsRecyclerview.adapter = adapter

        homeViewModel.posts.observe(viewLifecycleOwner) { posts ->
            adapter.update(posts)
        }
        binding.homeScheduleButton.setOnClickListener {
            it.findNavController().navigate(
                HomeFragmentDirections.actionNavHomeToNavSchedule()
            )
        }
        binding.homeTeamButton.setOnClickListener {
            it.findNavController().navigate(
                HomeFragmentDirections.actionNavHomeToNavTeam()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}