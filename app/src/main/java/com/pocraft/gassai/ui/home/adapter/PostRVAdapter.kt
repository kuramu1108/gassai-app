package com.pocraft.gassai.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.pocraft.gassai.databinding.ItemPostBinding
import com.pocraft.gassai.ui.home.HomeFragmentDirections.Companion.actionNavHomeToChrome
import com.pocraft.gassai.model.Post
import java.time.format.DateTimeFormatter

class PostRVAdapter(
    private var data: List<Post> = listOf(),
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
                binding.postItemLayout.setOnClickListener {
                    it.findNavController().navigate(actionNavHomeToChrome(url))
                }
            }
        }
    }

    fun update(data: List<Post>) {
        this.data = data
        notifyDataSetChanged()
    }
}

class PostViewHolder(val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root)