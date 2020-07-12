package com.pocraft.gassai.ui.schedule.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.databinding.ItemSessionBinding
import com.pocraft.gassai.model.Session
import com.pocraft.gassai.model.SessionWithTeam

class SessionsRVAdapter(
    private var data: List<SessionWithTeam> = listOf()
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

    fun update(data: List<SessionWithTeam>) {
        this.data = data
        notifyDataSetChanged()
    }
}

class SessionViewHolder(val binding: ItemSessionBinding) : RecyclerView.ViewHolder(binding.root)