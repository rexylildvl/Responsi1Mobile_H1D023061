package com.unsoed.responsi1mobile_h1d023061.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unsoed.responsi1mobile_h1d023061.data.model.TeamResponse
import com.unsoed.responsi1mobile_h1d023061.data.repository.TeamRepository
import kotlinx.coroutines.launch

class TeamViewModel : ViewModel() {
    private val repository = TeamRepository()
    val teamData = MutableLiveData<TeamResponse>()
    val errorMessage = MutableLiveData<String>()

    fun fetchTeamData(teamId: Int, token: String) {
        viewModelScope.launch {
            try {
                val response = repository.getTeam(teamId, token)
                if (response.isSuccessful) {
                    teamData.postValue(response.body())
                } else {
                    errorMessage.postValue("Error: ${response.code()}")
                }
            } catch (e: Exception) {
                errorMessage.postValue(e.message)
            }
        }
    }
}
