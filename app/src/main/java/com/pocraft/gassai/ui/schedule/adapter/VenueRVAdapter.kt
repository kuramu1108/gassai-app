package com.pocraft.gassai.ui.schedule.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.databinding.ItemVenueBinding
import com.pocraft.gassai.model.Venue
import com.pocraft.gassai.ui.schedule.viewmodel.SessionViewModel

class VenueRVAdapter(
    private val data: List<Venue>,
    private val sessionViewModel: SessionViewModel
) : RecyclerView.Adapter<VenueViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueViewHolder {
        val binding = ItemVenueBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return VenueViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: VenueViewHolder, position: Int) {
        with(holder) {
            binding.venueBtn.text = data[position].name

        }
    }
}

class VenueViewHolder(val binding: ItemVenueBinding) : RecyclerView.ViewHolder(binding.root)