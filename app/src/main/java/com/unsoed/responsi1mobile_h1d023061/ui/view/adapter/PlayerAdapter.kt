package com.unsoed.responsi1mobile_h1d023061.ui.view.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.unsoed.responsi1mobile_h1d023061.data.model.Player
import com.unsoed.responsi1mobile_h1d023061.databinding.ItemPlayerBinding

class PlayerAdapter(
    private val players: List<Player>,
    private val onItemClick: (Player) -> Unit
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]

        holder.binding.tvPlayerName.text = player.name
        holder.binding.tvPlayerCountry.text = player.country

        // Warna card sesuai posisi
        val color = when (player.position) {
            "Goalkeeper" -> Color.parseColor("#FFFF00")
            "Defender" -> Color.parseColor("#0000FF")
            "Midfielder" -> Color.parseColor("#00FF00")
            "Forward" -> Color.parseColor("#FF0000")
            else -> Color.parseColor("#808080")
        }
        holder.binding.cardPlayer.setCardBackgroundColor(color)

        // Klik item → kirim ke listener
        holder.itemView.setOnClickListener {
            onItemClick(player)
        }
    }

    override fun getItemCount(): Int = players.size
}
