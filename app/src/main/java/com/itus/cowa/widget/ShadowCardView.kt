package com.itus.cowa.widget

import android.content.Context
import android.graphics.Outline
import android.graphics.Rect
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.FrameLayout
import androidx.annotation.FloatRange

class ShadowCardView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {

    private val density by lazy {
        resources.displayMetrics.density
    }

    private val _outlineProvider =
            OutlineProvider(yShift = (-3 * density).toInt(),
                    corner = 8f * density
            )

    override fun drawableStateChanged() {
        super.drawableStateChanged()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            elevation = 10 * density
        }
    }

    class OutlineProvider(
            private val rect: Rect = Rect(),
            var scaleX: Float = 1f,
            var scaleY: Float = 1f,
            var yShift: Int,
            val corner: Float,
    ) : ViewOutlineProvider() {

        override fun getOutline(view: View?, outline: Outline?) {
            view?.background?.copyBounds(rect)
            rect.scale(scaleX, scaleY)
            rect.offset(0, yShift)

            val cornerRadius = corner
            outline?.setRoundRect(rect, cornerRadius)
        }

        private fun Rect.scale(
                @FloatRange(from = -1.0, to = 1.0) scaleX: Float,
                @FloatRange(from = -1.0, to = 1.0) scaleY: Float,
        ) {
            val newWidth = width() * scaleX
            val newHeight = height() * scaleY
            val deltaX = (width() - newWidth) / 2
            val deltaY = (height() - newHeight) / 2
            set(
                    (left + deltaX).toInt(),
                    (top + deltaY).toInt(),
                    (right - deltaX).toInt(),
                    (bottom - deltaY).toInt()
            )
        }
    }

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            outlineAmbientShadowColor = 0x7A000000
            outlineSpotShadowColor = 0x7A000000
            outlineProvider = _outlineProvider
            clipToPadding = false
        }
        setWillNotDraw(false)
    }
}