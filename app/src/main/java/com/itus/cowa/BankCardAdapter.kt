package com.itus.cowa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itus.cowa.databinding.BankCardItemBinding

class BankCardAdapter(
        private val onCardClickListener: OnCardClickListener,
) : RecyclerView.Adapter<BankCardAdapter.BankCardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankCardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.bank_card_item, parent, false)
        return BankCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: BankCardViewHolder, position: Int) {
        holder.bind(onCardClickListener)
    }

    override fun getItemCount(): Int {
        return 10
    }

    class BankCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = BankCardItemBinding.bind(itemView)

        fun bind(
                onCardClickListener: OnCardClickListener,
        ) {
            itemView.setOnClickListener {
                onCardClickListener.onCardClick(position)
            }
        }
    }
}

interface OnCardClickListener {
    fun onCardClick(position: Int)
}