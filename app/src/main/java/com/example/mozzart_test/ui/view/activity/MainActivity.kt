package com.example.mozzart_test.ui.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mozzart_test.data.model.DrawData
import com.example.mozzart_test.databinding.ActivityMainBinding
import com.example.mozzart_test.ui.adapters.DrawAdapter
import com.example.mozzart_test.viewmodel.DrawViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawAdapter: DrawAdapter
    private val drawViewModel: DrawViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawViewModel.fetchUpcomingDraws()
        setupRecyclerView()
        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            drawViewModel.drawDataStateFlow.collect { draws ->
                Timber.d("observeViewModel $draws")
                drawAdapter.refreshList(draws)
                Timber.d("observeViewMode drawTimes size : ${draws.size}")
                Timber.d("Draw list adapter  ${drawAdapter.itemCount}")
            }
        }
    }


    private fun setupRecyclerView() {
        //TODO DEFINE MAIN COLORS THEME IN APPS align with material design
        drawAdapter = DrawAdapter { openDrawDetails(it) }
        binding.recyclerViewDraws.apply {
            adapter = drawAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL
                )
            )
        }

    }

    private fun openDrawDetails(drawData: DrawData?) {
//        Toast.makeText(
//            this,
//            "TIME is ${draw?.drawTime} and id is ${draw?.drawId}",
//            Toast.LENGTH_SHORT
//        ).show()
        val intent = Intent(this, ResultActivity::class.java)
      //  intent.putExtra(Constants.DRAW_ID, draw.drawId)
        startActivity(intent)
    }
}