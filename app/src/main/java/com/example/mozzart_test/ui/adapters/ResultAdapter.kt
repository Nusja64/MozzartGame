package com.example.mozzart_test.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mozzart_test.R
import com.example.mozzart_test.data.model.Content
import com.example.mozzart_test.databinding.ItemResultBinding
import com.example.mozzart_test.utils.Constants
import com.example.mozzart_test.utils.toHourMinuteFormat
import timber.log.Timber

class ResultAdapter(private var contentList: MutableList<Content> = mutableListOf()) :
    RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemResultBinding.inflate(inflater, parent, false)
        return ResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val result = contentList[position]
        holder.bind(result)
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    fun setDrawings(results: List<Content>) {
        Timber.d("setDrawings called : ${results.size}")
        contentList.clear()
        contentList.addAll(results)
        notifyDataSetChanged()
    }

    class ResultViewHolder(private val binding: ItemResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(content: Content) {
            binding.apply {
                val formattedString = ContextCompat.getString(
                    root.context,
                    R.string.result_header_text
                )
                textViewHeader.text =
                    String.format(
                        formattedString,
                        content.drawTime?.toHourMinuteFormat(),
                        content.drawId
                    )
                val ballAdapter = content.winningNumbers?.list?.let { balls -> BallAdapter(balls) }
                recyclerViewBall.apply {
                    layoutManager = GridLayoutManager(context, Constants.RESULT_BALL_COLUMN)
                    adapter = ballAdapter
                }
            }
        }


    }
}
