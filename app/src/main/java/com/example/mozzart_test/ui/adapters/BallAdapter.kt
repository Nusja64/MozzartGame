package com.example.mozzart_test.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mozzart_test.databinding.ItemBallBinding
import com.example.mozzart_test.utils.ColorConstants

class BallAdapter(private val balls: List<Int>) :
    RecyclerView.Adapter<BallAdapter.BallViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BallViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBallBinding.inflate(inflater, parent, false)
        return BallViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BallViewHolder, position: Int) {
        val ball = balls[position]
        holder.bind(ball)
    }

    override fun getItemCount(): Int {
        return balls.size
    }

    class BallViewHolder(private val binding: ItemBallBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ball: Int) {
            binding.apply {
                ballColorView.backgroundTintList = ColorConstants.getColor(ball)
                numberTextView.text = ball.toString()
            }
        }
    }
}
