package com.unsoed.responsi1mobile_h1d023061.ui.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.unsoed.responsi1mobile_h1d023061.R
import androidx.lifecycle.lifecycleScope
import com.unsoed.responsi1mobile_h1d023061.data.api.RetrofitInstance
import com.unsoed.responsi1mobile_h1d023061.data.model.Coach
import com.unsoed.responsi1mobile_h1d023061.databinding.ActivityCoachBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoachBinding
    private val apiKey = "485cb0fb9ed3494e9c88ec71017b1371"
    private val teamId = 80

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivCoachPhoto.setImageResource(R.drawable.coach)
        binding.cardCoachInfo.visibility = View.GONE

        Handler(Looper.getMainLooper()).postDelayed({
            loadCoachFromApi()
        }, 2000)
    }

    private fun loadCoachFromApi() {
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.getTeam(teamId, apiKey)

                if (response.isSuccessful) {
                    val coachApi = response.body()?.coach
                    val coach: Coach? = coachApi?.toCoach()

                    withContext(Dispatchers.Main) {
                        if (coach != null) {
                            binding.tvCoachName.text = coach.name
                            binding.tvCoachBirth.text = coach.dateOfBirth
                            binding.tvCoachNationality.text = coach.nationality
                            binding.cardCoachInfo.visibility = View.VISIBLE
                        } else {
                            Toast.makeText(this@CoachActivity, "Coach data not found", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@CoachActivity, "Failed to fetch team data", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@CoachActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
