package com.itus.cowa.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class SpacingItemDecoration(private val mSpaceHeight: Int) : ItemDecoration() {
    override fun getItemOffsets(
            outRect: Rect,
            view: View, parent: RecyclerView, state: RecyclerView.State,
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val isLastItem = parent.getChildAdapterPosition(view) == parent.adapter!!.itemCount - 1
        if (!isLastItem) outRect.bottom = mSpaceHeight else outRect.bottom = mSpaceHeight * 2
        val isFirstItem = parent.getChildAdapterPosition(view) == 0
        if (isFirstItem) outRect.top = mSpaceHeight * 2
    }
}