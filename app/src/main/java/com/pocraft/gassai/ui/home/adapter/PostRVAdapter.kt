package com.pocraft.gassai.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.databinding.ItemPostBinding
import com.pocraft.gassai.model.Post
import java.time.format.DateTimeFormatter

class PostRVAdapter(
    private val data: List<Post>,
    private val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
) : RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PostViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        with(holder) {
            with(data[position]) {
                binding.postDate.text = date.format(dateTimeFormatter)
                binding.postTitle.text = title
            }
        }
    }

}

class PostViewHolder(val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root)