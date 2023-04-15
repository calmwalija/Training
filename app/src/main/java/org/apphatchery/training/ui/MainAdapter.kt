package org.apphatchery.training.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.apphatchery.training.databinding.ActivityMainItemBinding
import org.apphatchery.training.domain.model.Message

class MainAdapter : ListAdapter<Message, MainAdapter.ViewHolder>(differ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ActivityMainItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }


    inner class ViewHolder(private val binding: ActivityMainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(message: Message) = binding.apply {
            this.message = message
            executePendingBindings()
        }
    }


    companion object {
        val differ = object : DiffUtil.ItemCallback<Message>() {

            override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
                return oldItem.username == newItem.username
            }
        }

    }


}