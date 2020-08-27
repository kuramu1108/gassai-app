package com.pocraft.gassai.ui.schedule.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.R
import com.pocraft.gassai.databinding.ItemSessionBinding
import com.pocraft.gassai.model.Session
import com.pocraft.gassai.model.SessionWithTeam
import com.pocraft.gassai.ui.schedule.viewmodel.SessionViewModel
import java.time.format.DateTimeFormatter

class SessionsRVAdapter(
    private val vm: SessionViewModel
) : ListAdapter<SessionWithTeam, SessionViewHolder>(SessionDiffUtilCallBack()) {
    private val formatter = DateTimeFormatter.ofPattern("HH:mm")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        val binding = ItemSessionBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return SessionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        with(holder.binding) {
            with(getItem(position)) {
                sessionTeam.text = team.name
                sessionTime.text = session.time.format(formatter)
                sessionFavorite.isSelected = session.isFavorite
                sessionFavorite.setOnClickListener {
                    sessionFavorite.isSelected = !sessionFavorite.isSelected
                    vm.toggleFavorite(session)
                }
            }
        }
    }
}

class SessionViewHolder(val binding: ItemSessionBinding) : RecyclerView.ViewHolder(binding.root)

class SessionDiffUtilCallBack : DiffUtil.ItemCallback<SessionWithTeam>() {
    override fun areItemsTheSame(oldItem: SessionWithTeam, newItem: SessionWithTeam): Boolean =
        oldItem.session.sessionId == newItem.session.sessionId

    override fun areContentsTheSame(
        oldItem: SessionWithTeam,
        newItem: SessionWithTeam
    ): Boolean = oldItem.session.sessionId == newItem.session.sessionId
}