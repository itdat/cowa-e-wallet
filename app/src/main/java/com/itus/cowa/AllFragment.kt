package com.itus.cowa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.itus.cowa.adapter.ParentAdapter
import com.itus.cowa.databinding.FragmentAllBinding
import com.itus.cowa.model.Parent
import com.itus.cowa.utils.SpacingItemDecoration

class AllFragment(private val list: List<Parent>) : Fragment() {
    private var _binding: FragmentAllBinding? = null
    private val binding: FragmentAllBinding
        get() = _binding ?: throw IllegalStateException("View is not inflated yet.")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAllBinding.bind(view)
        binding.rvParent.apply {
            adapter = ParentAdapter(list)
            addItemDecoration(SpacingItemDecoration(20))
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_all, container, false)
    }

    companion object {
        fun newInstance(list: List<Parent>) = AllFragment(list)
    }
}