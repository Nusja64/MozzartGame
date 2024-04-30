package com.example.mozzart_test.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mozzart_test.data.model.DrawData
import com.example.mozzart_test.databinding.ItemDrawBinding
import com.example.mozzart_test.utils.getRemainingTime
import com.example.mozzart_test.utils.toHourMinuteFormat
import timber.log.Timber


class DrawAdapter(
    private val drawData: MutableList<DrawData> = mutableListOf(),
    private val onItemClickListener: ((DrawData) -> Unit)? = null
) : RecyclerView.Adapter<DrawAdapter.DrawViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrawViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDrawBinding.inflate(inflater, parent, false)
        return DrawViewHolder(binding) { onItemClickListener?.invoke(drawData[it]) }
    }

    override fun onBindViewHolder(holder: DrawViewHolder, position: Int) {
        val draw = drawData[position]
        holder.bind(draw)
    }

    override fun getItemCount(): Int {
        return drawData.size
    }

    class DrawViewHolder(
        private val binding: ItemDrawBinding,
        private val clickAtPosition: ((Int) -> Unit)?
    ) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener { clickAtPosition?.invoke(adapterPosition) }
        }


        fun bind(drawData: DrawData) {
            binding.apply {
                textViewDrawTime.text = drawData.drawTime.toHourMinuteFormat()
                Timber.d("Draw time : ${drawData.drawTime.toHourMinuteFormat()}")
                textViewRemainingTime.text = drawData.drawTime.getRemainingTime()
                Timber.d("RemainingTime  time : ${textViewRemainingTime.text}")
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshList(drawDataList: List<DrawData>) {
        Timber.d("refreshList called : ${drawData.size}")
        drawData.clear()
        drawData.addAll(drawDataList)
        notifyDataSetChanged()
    }

}


