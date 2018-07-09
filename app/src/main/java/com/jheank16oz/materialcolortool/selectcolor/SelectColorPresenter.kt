package com.jheank16oz.materialcolortool.selectcolor

import com.jheank16oz.materialcolortool.R
import com.jheank16oz.materialcolortool.model.ColorItem
import com.jheank16oz.materialcolortool.model.ColorSeparatorItem


class SelectColorPresenter(private val selectColorView: SelectColorContract.View) : SelectColorContract.Presenter {

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

        val data: ArrayList<Any> = ArrayList()
        data.add(ColorSeparatorItem(1,"Prueba 1.0"))
        data.add(ColorItem(2,"Prueba 1", R.color.colorAccent))
        data.add(ColorItem(3,"Prueba 1", R.color.colorAccent))
        data.add(ColorItem(4,"Prueba 1", R.color.colorAccent))
        data.add(ColorItem(4,"Prueba 1", R.color.colorAccent))
        data.add(ColorItem(4,"Prueba 1", R.color.colorAccent))
        data.add(ColorItem(4,"Prueba 1", R.color.colorAccent))
        data.add(ColorSeparatorItem(1,"Prueba 1.1"))
        data.add(ColorItem(2,"Prueba 1", R.color.colorAccent))
        data.add(ColorItem(3,"Prueba 1", R.color.colorAccent))
        data.add(ColorItem(4,"Prueba 1", R.color.colorAccent))
        data.add(ColorItem(4,"Prueba 1", R.color.colorAccent))
        data.add(ColorItem(4,"Prueba 1", R.color.colorAccent))
        data.add(ColorItem(4,"Prueba 1", R.color.colorAccent))
        data.add(ColorSeparatorItem(1,"Prueba 1.2"))
        data.add(ColorItem(2,"Prueba 1", R.color.colorAccent))
        data.add(ColorItem(3,"Prueba 1", R.color.colorAccent))
        data.add(ColorItem(4,"Prueba 1", R.color.colorAccent))
        data.add(ColorItem(4,"Prueba 1", R.color.colorAccent))
        data.add(ColorItem(4,"Prueba 1", R.color.colorAccent))
        data.add(ColorItem(4,"Prueba 1", R.color.colorAccent))

        selectColorView.displayData(data)

    }
}