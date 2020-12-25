package com.itus.cowa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itus.cowa.R
import com.itus.cowa.databinding.ParentRecyclerBinding
import com.itus.cowa.model.Parent
import com.itus.cowa.utils.SpacingItemDecoration

class ParentAdapter(private val parents: List<Parent>) : RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.parent_recycler, parent, false)
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val parent = parents[position]
        holder.bind(parent)
    }

    override fun getItemCount(): Int {
        return parents.size
    }

    inner class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ParentRecyclerBinding.bind(itemView)

        fun bind(parent: Parent) {
            binding.time.text = parent.time
            binding.rvChild.apply {
                adapter = TransactionAdapter(parent.transactions)
                setRecycledViewPool(viewPool)
            }
        }
    }
}