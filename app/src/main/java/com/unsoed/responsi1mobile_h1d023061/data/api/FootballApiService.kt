package com.unsoed.responsi1mobile_h1d023061.data.api

import com.unsoed.responsi1mobile_h1d023061.data.model.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FootballApiService {
    @GET("teams/{id}")
    suspend fun getTeam(
        @Path("id") id: Int,
        @Header("X-Auth-Token") apiKey: String
    ): Response<TeamResponse>
}
