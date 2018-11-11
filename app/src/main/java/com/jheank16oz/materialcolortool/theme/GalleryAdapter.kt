package com.jheank16oz.materialcolortool.theme

import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.jheank16oz.materialcolortool.R
import com.jheank16oz.materialcolortool.model.ImageModel


/**
 *
 *  <p>GalleryAdapter</p>
 */
class GalleryAdapter(internal var context: Context, data: List<ImageModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    internal var data: List<ImageModel> = ArrayList()

    init {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder
        val v: View = LayoutInflater.from(parent.context).inflate(
                R.layout.item_gallery, parent, false)
        viewHolder = MyItemHolder(v)

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        Glide.with(context).load(data[position].url)
                .thumbnail(0.5f)
                .transition(DrawableTransitionOptions()
                        .crossFade())
                .apply(RequestOptions()
                .override(200, 200)
                .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into((holder as MyItemHolder).mImg)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var mImg: ImageView = itemView.findViewById(R.id.item_img) as ImageView
    }


}