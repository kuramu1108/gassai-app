package com.pocraft.gassai.ui.schedule

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.transition.TransitionManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
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

/**
 * A simple [Fragment] subclass.
 * Use the [SessionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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

//        if (sessionSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
//        sessionSheetBehavior.onLayoutChild(
//            binding.coordinator,
//            binding.scheduleList,
//            View.LAYOUT_DIRECTION_LTR
//        )

        sessionSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                sessionViewModel.setBottomSheetState(when(newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> BottomSheetState.COLLAPSED
                    BottomSheetBehavior.STATE_EXPANDED -> BottomSheetState.EXPANDED
                    else -> BottomSheetState.TRANSFORMING
                })
            }

        })
//        binding.toggleBtn.setOnClickListener(BackdropMenuToggler(requireActivity(), binding.scheduleList))
//        binding.sessionsFragmentLbl.text = args.tabIndex.toString()
        binding.toggleBtn.setOnClickListener {
            sessionViewModel.viewBackDrop()
        }

        sessionViewModel.venueList.observe(viewLifecycleOwner) { list: List<Venue> ->
            binding.venueBackdrop.adapter = VenueRVAdapter(list, sessionViewModel)
        }
        sessionViewModel.selectedVenue.observe(viewLifecycleOwner) { venue ->
            binding.venueText.text = venue
        }
        sessionViewModel.bottomSheetState.observe(viewLifecycleOwner) { state ->
            when (state) {
                BottomSheetState.EXPANDED -> {
                    sessionSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
                BottomSheetState.COLLAPSED -> {
                    sessionSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                }
            }
        }

        sessionViewModel.sessionList.observe(viewLifecycleOwner) { sessions ->
            binding.sessionRecyclerview.adapter = SessionsRVAdapter(sessions)
        }

//        sessionViewModel.venueSelected(0)
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