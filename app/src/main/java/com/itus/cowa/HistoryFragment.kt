package com.itus.cowa

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearSnapHelper
import com.itus.cowa.adapter.BankCardAdapter
import com.itus.cowa.adapter.OnCardClickListener
import com.itus.cowa.adapter.ViewPagerAdapter
import com.itus.cowa.databinding.FragmentHistoryBinding
import com.itus.cowa.model.ParentFactory

class HistoryFragment : Fragment(), OnCardClickListener {
    private var _binding: FragmentHistoryBinding? = null
    private val binding: FragmentHistoryBinding
        get() = _binding ?: throw IllegalStateException("View is not inflated yet.")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHistoryBinding.bind(view)
        binding.recyclerView.adapter = BankCardAdapter(this)
        binding.recyclerView.setHasFixedSize(true)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerView)
        binding.tabs.setupWithViewPager(binding.viewpager)
        setupViewPager()
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(fragmentManager)
        adapter.addFrag(AllFragment.newInstance(ParentFactory.getAllParents()), "Tất cả")
        adapter.addFrag(AllFragment.newInstance(ParentFactory.getListSpend()), "Khoản chi")
        adapter.addFrag(AllFragment.newInstance(ParentFactory.getListReceipt()), "Khoản thu")
        binding.viewpager.adapter = adapter
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
        startActivity(Intent(activity, TransactionActivity::class.java))
    }
}