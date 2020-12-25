package com.itus.cowa.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itus.cowa.R
import com.itus.cowa.databinding.ItemTransactionBinding
import com.itus.cowa.model.Transaction
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.*


class TransactionAdapter(private val transactions: List<Transaction>) : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_transaction, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.bind(transaction)
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

    class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemTransactionBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun bind(transaction: Transaction) {
            binding.iconTransaction.setImageResource(transaction.idIcon)
            binding.textViewName.text = transaction.name
            binding.textViewNote.text = transaction.note
            val pageFollowCountSymbols = DecimalFormatSymbols(Locale("en_US"))
            pageFollowCountSymbols.groupingSeparator = '.'
            val pageFollowCountFormat = DecimalFormat("###,###", pageFollowCountSymbols);

            binding.textViewPrice.text = pageFollowCountFormat.format(transaction.amount) + " VND"
            if (transaction.amount > 0) binding.textViewPrice.setTextColor(Color.parseColor("#23C27F"))
            else binding.textViewPrice.setTextColor(Color.parseColor("#BF4B4B"))
        }

    }

}