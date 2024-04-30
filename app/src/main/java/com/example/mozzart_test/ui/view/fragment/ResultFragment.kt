package com.example.mozzart_test.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mozzart_test.data.model.Content
import com.example.mozzart_test.databinding.FragmentResultBinding
import com.example.mozzart_test.ui.adapters.ResultAdapter
import com.example.mozzart_test.viewmodel.ResultViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private lateinit var resultAdapter: ResultAdapter
    private val resultViewModel: ResultViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultViewModel.loadResultData()
        setupRecyclerView()
        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            resultViewModel.resultStateFlow.collect { results ->
                Timber.d("Result observeViewModel $results")
                results.content?.let {
                    binding.progressCircular.visibility = View.GONE
                    loadDrawings(it)
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.progressCircular.visibility = View.VISIBLE
        resultAdapter = ResultAdapter()
        binding.recyclerViewResults.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = resultAdapter
        }
    }

    private fun loadDrawings(data: List<Content>) {
        resultAdapter.setDrawings(data)
    }


    // this was test function before implementing api call
    private fun generateDummyDrawings(): List<List<Int>> {
        val drawings = mutableListOf<List<Int>>()
        repeat(10) {
            val drawing = mutableListOf<Int>()
            repeat(20) {
                drawing.add((1..80).random())
            }
            drawings.add(drawing)
        }
        return drawings
    }
}