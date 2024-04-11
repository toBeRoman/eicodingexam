package com.tobyrodinroman.eicodingexam.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tobyrodinroman.eicodingexam.data.model.GetLevelsResponse
import com.tobyrodinroman.eicodingexam.data.repository.LevelsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val levelsRepository: LevelsRepository
) : ViewModel() {

    private val _levels = MutableLiveData<GetLevelsResponse>()
    val levels: LiveData<GetLevelsResponse> = _levels

    fun loadLevels() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = levelsRepository.getLevels()
                _levels.postValue(data)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}
