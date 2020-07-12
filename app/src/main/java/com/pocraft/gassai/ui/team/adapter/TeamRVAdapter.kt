package com.pocraft.gassai.ui.team.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.databinding.ItemTeamBinding
import com.pocraft.gassai.model.Team

class TeamRVAdapter(
    private var data: List<Team> = listOf()
) : RecyclerView.Adapter<TeamViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = ItemTeamBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TeamViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        with(holder) {
            with(data[position]) {
                binding.teamName.text = name
                binding.teamOrigin.text = "$prefecture $region"
                binding.teamFestival.text = festival
            }
        }
    }

    fun update(data: List<Team>) {
        this.data = data
        notifyDataSetChanged()
    }
}

class TeamViewHolder(val binding: ItemTeamBinding) : RecyclerView.ViewHolder(binding.root)