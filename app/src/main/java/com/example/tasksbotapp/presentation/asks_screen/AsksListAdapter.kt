package com.example.tasksbotapp.presentation.asks_screen


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tasksbotapp.databinding.AskBinding
import com.example.tasksbotapp.domain.model.Ask


class AsksListAdapter : ListAdapter<Ask, AsksListAdapter.ItemHolder>(ItemComparator()) {

    class ItemHolder(private val binding: AskBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(ask: Ask) {
            binding.userAsk.setText(ask.text)
            binding.userNameAsk.setText(ask.name)

        }
        companion object{
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(AskBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<Ask>(){
        override fun areItemsTheSame(oldItem: Ask, newItem: Ask): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Ask, newItem: Ask): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }
}