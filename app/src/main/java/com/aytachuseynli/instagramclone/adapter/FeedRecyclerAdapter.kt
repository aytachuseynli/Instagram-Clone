package com.aytachuseynli.instagramclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aytachuseynli.instagramclone.databinding.RecyclerRowBinding
import com.aytachuseynli.instagramclone.model.Post
import com.bumptech.glide.Glide

class FeedRecyclerAdapter(private val postList: ArrayList<Post>):RecyclerView.Adapter<FeedRecyclerAdapter.PostHolder>() {

    class PostHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostHolder(binding)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.binding.rvEmailText.text = postList.get(position).email
        holder.binding.rvCommentText.text = postList.get(position).comment
        Glide.with(holder.itemView.context)
            .load(postList.get(position).downloadUrl)
            .into(holder.binding.rvImageView)

    }

    override fun getItemCount():Int {
        return postList.size
    }
}