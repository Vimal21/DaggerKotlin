package com.vimal.newsapp.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.vimal.newsapp.R
import com.vimal.newsapp.databinding.ItemPostBinding
import com.vimal.newsapp.model.Post

/**
 * Adapter for the list of the posts
 * @property context Context in which the application is running
 */
class PostAdapter(private val context: Context) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    /**
     * The list of posts of the adapter
     */
    private var posts: List<Post> = listOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): PostAdapter.ViewHolder {
        val layoutInflater  = LayoutInflater.from(context)
        val binding : ItemPostBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_post, viewGroup, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(posts[position])
    }

    /**
     * Updates the list of posts of the adapter
     * @param posts the new list of posts of the adapter
     */
    fun updatePosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root){
        /**
         * func for binding the view
         */
        fun bind( post: Post){
            binding.post = post
            binding.executePendingBindings()
        }
    }
}