package com.tobyrodinroman.eicodingexam.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tobyrodinroman.eicodingexam.data.model.Level
import com.tobyrodinroman.eicodingexam.databinding.ActivityMainBinding
import com.tobyrodinroman.eicodingexam.presentation.main.adapters.LevelAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var levelAdapter: LevelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        viewModel.loadLevels()
        viewModel.levels.observe(this) { response ->
            val levels = response.levels
            levelAdapter.updateData(levels)
        }
    }

    private fun setupRecyclerView() {
        levelAdapter = LevelAdapter(emptyList())
        binding.rvMain.adapter = levelAdapter
        binding.rvMain.layoutManager = LinearLayoutManager(this)
    }
}