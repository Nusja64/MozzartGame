package com.example.mozzart_test.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SelectedNumbersAdapter(private val numbers: List<Int>) :
    RecyclerView.Adapter<SelectedNumbersAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val number = numbers[position]
        holder.textView.text = number.toString()
        holder.textView.setBackgroundColor(Color.YELLOW)
        holder.textView.setTextColor(Color.BLACK)
    }

    override fun getItemCount(): Int {
        return numbers.size
    }
}
