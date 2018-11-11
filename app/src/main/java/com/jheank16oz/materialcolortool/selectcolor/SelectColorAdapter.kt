package com.jheank16oz.materialcolortool.selectcolor

import android.content.Context
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jheank16oz.materialcolortool.R
import com.jheank16oz.materialcolortool.model.ColorItem
import io.doist.recyclerviewext.sticky_headers.StickyHeaders
import kotlinx.android.synthetic.main.selectcolor_header_item.view.*


class SelectColorAdapter(private var mCallback:SelectColorViewHolder.Callbacks, context:Context): RecyclerView.Adapter<RecyclerView.ViewHolder>(), StickyHeaders, StickyHeaders.ViewSetup {

    private var stuckHeaderElevation:Float = context.resources.getDimension(R.dimen.card_elevation)
    private val mItems = ArrayList<Any>()

    override fun setupStickyHeaderView(view: View?) {
        view?.translationZ = stuckHeaderElevation
    }

    fun addAll(data:ArrayList<Any>){
        mItems.clear()
        mItems.addAll(data)
        notifyDataSetChanged()
    }
    override fun teardownStickyHeaderView(view: View?) {
        view?.translationZ = 10f
    }

    override fun isStickyHeader(position: Int): Boolean =
            getItemViewType(position) == ITEM_TYPE_COLOR_HEADER


    override fun getItemViewType(position: Int): Int {
        val item = mItems[position]
        return if ((item as ColorItem).type == "free") ITEM_TYPE_COLOR else ITEM_TYPE_COLOR_HEADER
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mItems[position]
        when (holder.itemViewType) {
            ITEM_TYPE_COLOR -> (holder as SelectColorViewHolder).bind(item as ColorItem)
            ITEM_TYPE_COLOR_HEADER -> (holder as ColorSeparatorViewHolder).bind((item as ColorItem), (mItems[position + 5] as ColorItem))
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
                            .inflate(R.layout.selectcolor_header_item, parent, false))
            else -> SelectColorViewHolder.newInstance(parent, mCallback)
        }
    }


    companion object {
        const val ITEM_TYPE_COLOR = 0
        const val ITEM_TYPE_COLOR_HEADER = 2
    }

    private class ColorSeparatorViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal fun bind(item: ColorItem, principal: ColorItem) {
            with(itemView) {
                val principalColor = Color.parseColor(principal.primaryColor)
                value.setColorFilter(principalColor)
                name.text = item.name
                name.setTextColor(principalColor)
            }

        }
    }
}
