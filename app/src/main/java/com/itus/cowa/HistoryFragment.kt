package com.itus.cowa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.itus.cowa.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment(), OnCardClickListener {
    private var _binding: FragmentHistoryBinding? = null
    private val binding: FragmentHistoryBinding
        get() = _binding ?: throw IllegalStateException("View is not inflated yet.")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHistoryBinding.bind(view)
        binding.recyclerView.adapter = BankCardAdapter(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HistoryFragment()
    }

    override fun onCardClick(position: Int) {
        TODO("Not yet implemented")
    }
}