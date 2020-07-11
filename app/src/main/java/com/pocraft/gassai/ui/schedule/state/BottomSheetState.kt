package com.pocraft.gassai.ui.schedule.state

enum class BottomSheetState {
    EXPANDED,
    TRANSFORMING,
    COLLAPSED;

    fun toggleState(): BottomSheetState {
        return when(this) {
            EXPANDED -> COLLAPSED
            COLLAPSED -> EXPANDED
            else -> this
        }
    }
}