package com.jheank16oz.materialcolortool.selectcolor

import android.content.Context
import com.google.gson.Gson
import com.jheank16oz.materialcolortool.R
import com.jheank16oz.materialcolortool.model.ColorItem
import com.jheank16oz.materialcolortool.util.JSONHandler
import com.google.gson.reflect.TypeToken




class SelectColorPresenter(private val selectColorView: SelectColorContract.View,val context:Context) : SelectColorContract.Presenter {

    override fun start() {
        //ignored
    }

    init {
        selectColorView.presenter = this
    }

    override fun initializeData() {
        if (!selectColorView.isActive){
            return
        }
        val colorsJson = JSONHandler.parseResource(context, R.raw.color_data)
        val list:ArrayList<Any> = Gson().fromJson(colorsJson, object : TypeToken<List<ColorItem>>() {}.type)
        selectColorView.displayData(list)
    }
}