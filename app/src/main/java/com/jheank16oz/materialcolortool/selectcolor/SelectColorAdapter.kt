package com.jheank16oz.materialcolortool.selectcolor

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jheank16oz.materialcolortool.model.ColorItem
import com.jheank16oz.materialcolortool.model.ColorSeparatorItem
import io.doist.recyclerviewext.sticky_headers.StickyHeaders


class SelectColorAdapter(var mCallback:SelectColorViewHolder.Callbacks): RecyclerView.Adapter<RecyclerView.ViewHolder>(), StickyHeaders, StickyHeaders.ViewSetup {

    private val mItems = ArrayList<Any>()

    override fun setupStickyHeaderView(view: View?) {
    }

    fun addAll(data:ArrayList<Any>){
        mItems.clear()
        mItems.addAll(data)
        notifyDataSetChanged()
    }
    override fun teardownStickyHeaderView(view: View?) {
        view?.translationZ = 0f
    }

    override fun isStickyHeader(position: Int): Boolean =
            getItemViewType(position) == ITEM_TYPE_COLOR_HEADER


    override fun getItemViewType(position: Int): Int {
        val item = mItems[position]
        return if (item is ColorItem) ITEM_TYPE_COLOR else ITEM_TYPE_COLOR_HEADER
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mItems[position]
        when (holder.itemViewType) {
            ITEM_TYPE_COLOR -> (holder as SelectColorViewHolder).bind(item as ColorItem)
            ITEM_TYPE_COLOR_HEADER -> (holder as ColorSeparatorViewHolder).bind(item as ColorSeparatorItem)
        }
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_TYPE_COLOR -> SelectColorViewHolder.newInstance(parent, mCallback)
            ITEM_TYPE_COLOR_HEADER -> ColorSeparatorViewHolder(
                    LayoutInflater.from(parent.context)
                            .inflate(android.R.layout.test_list_item, parent, false))
            else -> SelectColorViewHolder.newInstance(parent, mCallback)
        }
    }


    companion object {
        const val ITEM_TYPE_COLOR = 0
        const val ITEM_TYPE_COLOR_HEADER = 2
    }

    private class ColorSeparatorViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mColorSeparator: TextView = itemView as TextView

        internal fun bind(item: ColorSeparatorItem) {
            mColorSeparator.text = item.name
        }
    }
}
