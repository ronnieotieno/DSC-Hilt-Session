package com.ronnie.hilttutorial

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ronnie.hilttutorial.databinding.AdapterItemBinding
import com.ronnie.hilttutorial.model.Player

class PlayersAdapter(private val clicked: (String) -> Unit) :
    RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>() {

    private val playerList = ArrayList<Player>()

    @SuppressLint("NotifyDataSetChanged")
    fun setPlayers(list: List<Player>) {
        playerList.clear()
        playerList.addAll(list)
        notifyDataSetChanged()
    }

    inner class PlayerViewHolder(private val binding: AdapterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindPlayer(player: Player) {
            binding.apply {
                val name = root.context.getString(
                    R.string.name,
                    player.first_name, player.last_name
                )
                root.setOnClickListener {
                    clicked.invoke(name)
                }
                playerName.text = name
                position.text = root.context.getString(
                    R.string.adapter_item,
                    "Position", player.position
                )
                team.text = root.context.getString(
                    R.string.adapter_item,
                    "Team", player.team.full_name
                )
                division.text = root.context.getString(
                    R.string.adapter_item,
                    "Division", player.team.division
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(
            AdapterItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bindPlayer(playerList[position])
    }

    override fun getItemCount(): Int {
        return playerList.size
    }
}