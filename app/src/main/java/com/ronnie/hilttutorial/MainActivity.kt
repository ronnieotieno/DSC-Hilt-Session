package com.ronnie.hilttutorial

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.ronnie.hilttutorial.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val adapter =
        PlayersAdapter { name: String -> snackBarClickedPlayer(name) }
    @Inject
    lateinit var names: Names

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.allProductRecyclerView.adapter = adapter

        Toast.makeText(this@MainActivity, names.getName(), Toast.LENGTH_SHORT).show()

        binding.allProductRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            addItemDecoration(RecyclerViewItemDecoration())
        }

        lifecycleScope.launch {
            try {
                val players = viewModel.getPlayers()
                adapter.setPlayers(players.playersList)
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, e.toString(), Toast.LENGTH_SHORT).show()
            }
            binding.progress.isVisible = false
        }

    }

    private fun snackBarClickedPlayer(name: String) {
        val parentLayout = findViewById<View>(android.R.id.content)
        Snackbar.make(parentLayout, name, Snackbar.LENGTH_LONG)
            .show()
    }
}