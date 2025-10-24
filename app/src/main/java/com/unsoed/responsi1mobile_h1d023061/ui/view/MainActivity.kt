package com.unsoed.responsi1mobile_h1d023061.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unsoed.responsi1mobile_h1d023061.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardClubHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        binding.cardHeadCoach.setOnClickListener {
            startActivity(Intent(this, CoachActivity::class.java))
        }

        binding.cardTeamSquad.setOnClickListener {
            startActivity(Intent(this, SquadActivity::class.java))
        }
    }
}
