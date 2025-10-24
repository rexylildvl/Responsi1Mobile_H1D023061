package com.unsoed.responsi1mobile_h1d023061.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TeamResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("shortName")
    val shortName: String,

    @SerializedName("coach")
    val coach: CoachApi?,

    @SerializedName("squad")
    val squad: List<PlayerApi>
) : Serializable


data class CoachApi(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String,

    @SerializedName("dateOfBirth")
    val dateOfBirth: String?,

    @SerializedName("nationality")
    val nationality: String
) : Serializable {
    fun toCoach(): Coach {
        return Coach(
            id = id?.toString() ?: "unknown",
            name = name,
            dateOfBirth = dateOfBirth ?: "Unknown",
            nationality = nationality,
            position = "Head Coach"
        )
    }
}

data class Coach(
    val id: String,
    val name: String,
    val dateOfBirth: String,
    val nationality: String,
    val position: String
) : Serializable

data class PlayerApi(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("position")
    val position: String?,

    @SerializedName("dateOfBirth")
    val dateOfBirth: String?,

    @SerializedName("nationality")
    val nationality: String,

    @SerializedName("shirtNumber")
    val shirtNumber: Int?
) : Serializable {
    fun toPlayer(): Player {
        return Player(
            id = id.toString(),
            name = name,
            birthDate = dateOfBirth ?: "Unknown",
            country = nationality,
            position = mapPosition(position ?: "")
        )
    }

    private fun mapPosition(apiPosition: String): String {
        return when {
            apiPosition.equals("Goalkeeper", ignoreCase = true) -> "Goalkeeper"
            apiPosition.contains("Defence", ignoreCase = true) ||
                    apiPosition.contains("Defender", ignoreCase = true) -> "Defender"
            apiPosition.contains("Midfield", ignoreCase = true) ||
                    apiPosition.contains("Midfielder", ignoreCase = true) -> "Midfielder"
            apiPosition.contains("Forward", ignoreCase = true) ||
                    apiPosition.contains("Attacker", ignoreCase = true) ||
                    apiPosition.contains("Winger", ignoreCase = true) -> "Forward"
            else -> "Unknown"
        }
    }
}

data class Player(
    val id: String,
    val name: String,
    val birthDate: String,
    val country: String,
    val position: String
) : Serializable
