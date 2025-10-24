package com.unsoed.responsi1mobile_h1d023061.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.unsoed.responsi1mobile_h1d023061.data.api.RetrofitInstance
import com.unsoed.responsi1mobile_h1d023061.databinding.ActivitySquadBinding
import com.unsoed.responsi1mobile_h1d023061.ui.view.adapter.PlayerAdapter
import com.unsoed.responsi1mobile_h1d023061.ui.view.fragment.PlayerDetailFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SquadActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySquadBinding
    private lateinit var adapter: PlayerAdapter
    private val apiKey = "485cb0fb9ed3494e9c88ec71017b1371"
    private val teamId = 80

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewPlayers.layoutManager = LinearLayoutManager(this)

        loadSquadData()
    }

    private fun loadSquadData() {
        lifecycleScope.launch(Dispatchers.IO) {
            val response = RetrofitInstance.api.getTeam(teamId, apiKey)
            if (response.isSuccessful) {
                val players = response.body()?.squad?.map { it.toPlayer() } ?: emptyList()

                withContext(Dispatchers.Main) {
                    adapter = PlayerAdapter(players) { player ->
                        val detailFragment = PlayerDetailFragment.newInstance(player)
                        detailFragment.show(supportFragmentManager, "player_detail")
                    }

                    binding.recyclerViewPlayers.adapter = adapter
                }
            }
        }
    }
}
