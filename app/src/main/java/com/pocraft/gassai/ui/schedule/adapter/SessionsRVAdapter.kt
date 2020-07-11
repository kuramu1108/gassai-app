package com.pocraft.gassai.ui.schedule.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.databinding.ItemSessionBinding
import com.pocraft.gassai.model.Session

class SessionsRVAdapter(
    private val data: List<Session>
) : RecyclerView.Adapter<SessionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        val binding = ItemSessionBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return SessionViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        with(holder) {
            with(data[position]) {
                binding.sessionTeam.text = team.name
            }
        }
    }

}

class SessionViewHolder(val binding: ItemSessionBinding) : RecyclerView.ViewHolder(binding.root)