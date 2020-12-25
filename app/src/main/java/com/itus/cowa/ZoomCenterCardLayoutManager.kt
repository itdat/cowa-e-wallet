package com.itus.cowa

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs
import kotlin.math.min

// Ref: https://stackoverflow.com/questions/41307578/recycler-view-resizing-item-view-while-scrolling-for-carousel-like-effect

class ZoomCenterCardLayoutManager
    : LinearLayoutManager {

    private var shrinkAmount = 0.15f
    private var shrinkDistance = 1.5f

    constructor(context: Context?) : super(context)

    constructor(context: Context, orientation: Int, reverseLayout: Boolean)
            : super(context, orientation, reverseLayout)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes) {
        context.obtainStyledAttributes(attrs, R.styleable.RecyclerView,
                defStyleAttr, defStyleRes).apply {

            try {
                shrinkAmount = getFloat(R.styleable.RecyclerView_shrinkAmount, shrinkAmount)
                shrinkDistance = getFloat(R.styleable.RecyclerView_shrinkDistance, shrinkDistance)
            } finally {
                recycle()
            }
        }
    }

    override fun scrollHorizontallyBy(
            dx: Int,
            recycler: RecyclerView.Recycler?,
            state: RecyclerView.State?,
    ): Int {
        if (orientation == VERTICAL)
            return 0

        val scrolled = super.scrollHorizontallyBy(dx, recycler, state)

        val midPoint = width / 2f
        val d0 = 0f
        val d1 = shrinkDistance * midPoint
        val s0 = 1f
        val s1 = 1f - shrinkAmount

        for (i in 0 until childCount) {

            val child: View = getChildAt(i)!!
            val childMidPoint =
                    (getDecoratedRight(child) + getDecoratedLeft(child)) / 2f
            val d = min(d1, abs(midPoint - childMidPoint))
            val scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0)

            child.scaleX = scale
            child.scaleY = scale
        }

        return scrolled
    }

    override fun scrollVerticallyBy(dy: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
        if (orientation == HORIZONTAL)
            return 0

        val scrolled = super.scrollVerticallyBy(dy, recycler, state)

        val midPoint = height / 2f
        val d0 = 0f
        val d1 = shrinkDistance * midPoint
        val s0 = 1f
        val s1 = 1f - shrinkAmount

        for (i in 0 until childCount) {
            val child: View = getChildAt(i)!!
            val childMidPoint =
                    (getDecoratedBottom(child) + getDecoratedTop(child)) / 2f
            val d = min(d1, abs(midPoint - childMidPoint))
            val scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0)
            child.scaleX = scale
            child.scaleY = scale
        }

        return scrolled
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        super.onLayoutChildren(recycler, state)

        if (orientation == HORIZONTAL) {
            scrollHorizontallyBy(0, recycler, state)
        } else if (orientation == VERTICAL) {
            scrollVerticallyBy(0, recycler, state)
        }
    }

    companion object {
        val TAG = ZoomCenterCardLayoutManager::class.java.simpleName
    }
}