package com.unsoed.responsi1mobile_h1d023061.data.repository

import com.unsoed.responsi1mobile_h1d023061.data.api.RetrofitInstance
import com.unsoed.responsi1mobile_h1d023061.data.model.TeamResponse
import retrofit2.Response

class TeamRepository {
    suspend fun getTeam(id: Int, token: String): Response<TeamResponse> {
        return RetrofitInstance.api.getTeam(id, token)
    }
}
