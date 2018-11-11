package com.jheank16oz.materialcolortool.selectcolor


import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jheank16oz.materialcolortool.selectcolor.DividerDecoration.Divided

/**
 * An [ItemDecoration] which only draws **between** [ViewHolder]s that
 * require it as marked by implementing [Divided]. i.e. draws a divider line at the top
 * of an item if both it and the previous item are [Divided]. Currently requires a
 * [LinearLayoutManager].
 */
class DividerDecoration : ItemDecoration {
    private val mDividerPaint = Paint(ANTI_ALIAS_FLAG)
    private val mHalfHeight: Float

    constructor(dividerHeight: Float, @ColorInt dividerColor: Int) {
        mDividerPaint.strokeWidth = dividerHeight
        mHalfHeight = dividerHeight / 2f
        mDividerPaint.color = dividerColor
    }

    constructor(context: Context) {
        val a = context.obtainStyledAttributes(ATTRS)
        val dividerHeight = a.getDimension(0, 0f)
        mDividerPaint.strokeWidth = dividerHeight
        mHalfHeight = dividerHeight / 2f
        val index = 1
        mDividerPaint.color = a.getColor(index, 0xff00ff)
        a.recycle()
    }

    override fun onDraw(canvas: Canvas, rv: RecyclerView, state: RecyclerView.State) {
        val count = rv.childCount
        if (count < 2) return
        val points = FloatArray(count * 4)
        var previousItemNeedsDivider = false

        val layoutManager = rv.layoutManager as LinearLayoutManager?
        val firstVisibleItemPosition = layoutManager!!.findFirstVisibleItemPosition()
        for (i in 0 until count) {
            val holder = rv.findViewHolderForAdapterPosition(firstVisibleItemPosition + i)
            val needsDivider = holder is Divided
            if (previousItemNeedsDivider && needsDivider) {
                points[4 * i] = layoutManager.getDecoratedLeft(holder!!.itemView).toFloat()
                val top = (layoutManager.getDecoratedTop(holder.itemView).toFloat()
                        + holder.itemView.translationY + mHalfHeight)
                points[4 * i + 1] = top
                points[4 * i + 2] = layoutManager.getDecoratedRight(holder.itemView).toFloat()
                points[4 * i + 3] = top
            }
            previousItemNeedsDivider = needsDivider
        }
        canvas.drawLines(points, mDividerPaint)
    }

    /**
     * Empty marker interface, used to denote a [ViewHolder] as requiring a divider.
     */
    internal interface Divided

    companion object {

        private val ATTRS = intArrayOf(android.R.attr.dividerHeight, android.R.attr.divider)
    }
}