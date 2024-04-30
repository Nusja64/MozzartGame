package com.example.mozzart_test.ui.view.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.GridLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mozzart_test.databinding.FragmentCouponBinding
import com.example.mozzart_test.ui.adapters.SelectedNumbersAdapter

class CouponFragment : Fragment() {

    private val selectedNumbers = mutableSetOf<Int>()
    private lateinit var binding: FragmentCouponBinding
    private lateinit var gridView: GridLayout
    private lateinit var buttonRandom: Button
    private lateinit var spinnerColumns: Spinner
    private lateinit var recyclerViewSelectedNumbers: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCouponBinding.inflate(layoutInflater)
        gridView = binding.gridLayoutNumbers
        buttonRandom = binding.buttonRandom
        spinnerColumns = binding.spinnerColumns
        recyclerViewSelectedNumbers = binding.recyclerViewSelectedNumbers
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpSpinner()
        setListener()
    }

    private fun setListener() {
        buttonRandom.setOnClickListener {
            val selectedColumns = spinnerColumns.selectedItem.toString().toInt()
            val randomNumbers = (1..80).shuffled().take(selectedColumns)
            populateGrid(randomNumbers, selectedColumns)
        }
    }

    private fun setUpSpinner() {
        val columns = arrayOf("1", "2", "3", "4", "5", "6", "7", "8")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, columns)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerColumns.adapter = adapter
    }


    private fun populateGrid(numbers: List<Int>, columns: Int) {
        gridView.removeAllViews()
        selectedNumbers.clear()

        for (i in 1..80) {
            val textView = TextView(requireContext())
            textView.text = i.toString()
            textView.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
            textView.setPadding(8, 8, 8, 8)

            if (numbers.contains(i)) {
                textView.setBackgroundColor(Color.BLUE)
                textView.setTextColor(Color.WHITE)
                textView.setOnClickListener { toggleColor(textView, i) }
            }

            val params = GridLayout.LayoutParams()
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            gridView.addView(textView, params)
        }

        gridView.columnCount = columns
    }

    private fun toggleColor(textView: TextView, number: Int) {
        if (selectedNumbers.contains(number)) {
            selectedNumbers.remove(number)
            textView.setBackgroundColor(Color.BLUE)
            textView.setTextColor(Color.WHITE)
        } else {
            selectedNumbers.add(number)
            textView.setBackgroundColor(Color.YELLOW)
            textView.setTextColor(Color.BLACK)
        }

        updateSelectedNumbersView()
    }

    private fun updateSelectedNumbersView() {
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewSelectedNumbers.layoutManager = layoutManager
        val adapter = SelectedNumbersAdapter(selectedNumbers.toList())
        recyclerViewSelectedNumbers.adapter = adapter
    }
}
