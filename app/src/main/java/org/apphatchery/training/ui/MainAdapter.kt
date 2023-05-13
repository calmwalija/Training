package org.apphatchery.training.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

import org.apphatchery.training.data.local.MessageEntity
import org.apphatchery.training.databinding.ActivityMainItemBinding
import org.apphatchery.training.domain.model.Message
import org.apphatchery.training.domain.repository.Repository

class MainAdapter(private val onClickListener: OnClickListener) : ListAdapter<Message, MainAdapter.ViewHolder>(differ) {


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
            root.setOnClickListener {
                onClickListener.onItemClick(message)
            }
            executePendingBindings()
        }
    }

    interface OnClickListener {
        fun onItemClick(message: Message)
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


