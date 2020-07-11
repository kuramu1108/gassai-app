package com.pocraft.gassai.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.pocraft.gassai.databinding.FragmentScheduleBinding
import com.pocraft.gassai.ui.schedule.viewmodel.ScheduleViewModel

class ScheduleFragment : Fragment() {

    private val scheduleViewModel: ScheduleViewModel by viewModels()

    private var _binding: FragmentScheduleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        scheduleViewModel =
//            ViewModelProvider(this).get(ScheduleViewModel::class.java)
        _binding = FragmentScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabLayoutMediator = TabLayoutMediator(
            binding.sessionTabLayout,
            binding.sessionViewpager
        ) { tab, position ->
            tab.text = scheduleViewModel.schedules.value!![position]
        }

        binding.sessionViewpager.adapter = object :  FragmentStateAdapter(this) {
            override fun getItemCount(): Int = scheduleViewModel.schedules.value!!.size

            override fun createFragment(position: Int): Fragment {
                return SessionsFragment.newInstance(
                    SessionsFragmentArgs(position)
                )
            }

        }
        tabLayoutMediator.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}