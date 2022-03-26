package com.pocraft.gassai.ui.schedule

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.core.view.updatePadding
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.transition.TransitionManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.chip.Chip
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.pocraft.gassai.R
import com.pocraft.gassai.databinding.FragmentSessionsBinding
import com.pocraft.gassai.model.Venue
import com.pocraft.gassai.ui.schedule.adapter.SessionsRVAdapter
import com.pocraft.gassai.ui.schedule.adapter.VenueRVAdapter
import com.pocraft.gassai.ui.schedule.state.BottomSheetState
import com.pocraft.gassai.ui.schedule.viewmodel.ScheduleViewModel
import com.pocraft.gassai.ui.schedule.viewmodel.SessionViewModel
import com.pocraft.gassai.utility.doOnApplyWindowInsets
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SessionsFragment : Fragment(R.layout.fragment_sessions) {
    val scheduleViewModel by activityViewModels<ScheduleViewModel>()
    val sessionViewModel by viewModels<SessionViewModel>()

    private var _binding: FragmentSessionsBinding? = null
    private val binding get() = _binding!!

    private val args: SessionsFragmentArgs by lazy {
        SessionsFragmentArgs.fromBundle(
            arguments ?: Bundle()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSessionsBinding.bind(view)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            binding.scheduleList.background = context?.getDrawable()
            val shapeAppearanceModel = ShapeAppearanceModel.Builder()
                .setTopLeftCorner(
                    CornerFamily.ROUNDED,
                    resources.getDimension(R.dimen.bottom_sheet_corner_radius)
                )
                .build()
            val materialShapeDrawable = MaterialShapeDrawable.createWithElevationOverlay(
                requireActivity(),
                resources.getDimension(R.dimen.bottom_sheet_elevation)
            ).apply {
                setShapeAppearanceModel(shapeAppearanceModel)
            }
            binding.scheduleList.background = materialShapeDrawable
        }
        val sessionSheetBehavior = BottomSheetBehavior.from(binding.scheduleList)

        val initialPeekHeight = sessionSheetBehavior.peekHeight

        binding.scheduleList.doOnApplyWindowInsets { _, insets ->
            sessionSheetBehavior.peekHeight = insets.systemWindowInsetBottom + initialPeekHeight
            Log.d("PEEK", sessionSheetBehavior.peekHeight.toString())
        }
        binding.sessionRecyclerview.doOnApplyWindowInsets { view, insets ->
            view.updatePadding(
                bottom = insets.systemWindowInsetBottom
            )
        }

//        if (sessionSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
//        sessionSheetBehavior.onLayoutChild(
//            binding.coordinator,
//            binding.scheduleList,
//            View.LAYOUT_DIRECTION_LTR
//        )
        val adapter = SessionsRVAdapter(vm = sessionViewModel)
        binding.sessionRecyclerview.adapter = adapter

        sessionSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
//                Log.d("DEBUG", "$newState")
                sessionViewModel.setBottomSheetState(when(newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> BottomSheetState.COLLAPSED
                    BottomSheetBehavior.STATE_EXPANDED -> BottomSheetState.EXPANDED
                    else -> BottomSheetState.TRANSFORMING
                })
            }

        })
        binding.toggleBtn.setOnClickListener {
            sessionViewModel.viewBackDrop()
        }

        lifecycleScope.launch {
            sessionViewModel.state.collect { state ->
                if (binding.venueFilters.childCount == 0) {
                    state.venues.map {
                        val chip = layoutInflater.inflate(
                            R.layout.layout_choice_chip,
                            binding.venueFilters,
                            false
                        ) as Chip
                        chip.text = it.name
                        chip.setOnCheckedChangeListener { _, isChecked ->
                            if (isChecked) sessionViewModel.venueSelected(it)
                        }
                        binding.venueFilters.addView(chip)
                    }
                }

                binding.venueText.text = state.selectedVenue.name
                when (state.bottomSheetState) {
                    BottomSheetState.EXPANDED -> {
                        sessionSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                    }
                    BottomSheetState.COLLAPSED -> {
                        sessionSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                    }
                    BottomSheetState.TRANSFORMING -> Unit
                }
                val filteredSession = when(args.tabIndex) {
                    0 -> state.sessions.filter { it.session.day == 1 }
                    1 -> state.sessions.filter { it.session.day == 2 }
                    else -> state.sessions.filter { it.session.isFavorite }
                }
                adapter.submitList(filteredSession)
            }
        }
        sessionViewModel.save()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(args: SessionsFragmentArgs) =
            SessionsFragment().apply {
                arguments = args.toBundle()
            }
    }
}