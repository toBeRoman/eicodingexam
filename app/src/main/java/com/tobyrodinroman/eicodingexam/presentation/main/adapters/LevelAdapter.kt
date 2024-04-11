package com.tobyrodinroman.eicodingexam.presentation.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tobyrodinroman.eicodingexam.R
import com.tobyrodinroman.eicodingexam.data.model.Activity
import com.tobyrodinroman.eicodingexam.data.model.Level
import com.tobyrodinroman.eicodingexam.databinding.ItemLevelBinding


class LevelAdapter(private var levels: List<Level>) : RecyclerView.Adapter<LevelAdapter.LevelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelViewHolder {
        val binding = ItemLevelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LevelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LevelViewHolder, position: Int) {
        val level = levels[position]
        holder.bind(level)
        holder.binding.rvActivities.apply {
            adapter = ActivityAdapter(level.activities)
            layoutManager = GridLayoutManager(holder.itemView.context, 2)
        }
    }

    override fun getItemCount(): Int = levels.size

    fun updateData(newLevels: List<Level>) {
        levels = newLevels
        notifyDataSetChanged()
    }

    class LevelViewHolder(val binding: ItemLevelBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(level: Level) {
            binding.tvChapterLevel.text = "LEVEL ${level.level}"
            binding.tvChapterTitle.text = level.title
            binding.tvChapterDescription.text = level.description

            binding.rvActivities.adapter = ActivityAdapter(level.activities)
            binding.rvActivities.layoutManager = GridLayoutManager(itemView.context, 2)
        }

    }



}