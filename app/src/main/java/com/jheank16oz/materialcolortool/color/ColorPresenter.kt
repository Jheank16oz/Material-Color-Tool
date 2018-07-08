package com.jheank16oz.materialcolortool.color


class ColorPresenter(private val colorView: ColorContract.View) : ColorContract.Presenter {

    override fun start() {
        //ignored
    }

    init {
        colorView.presenter = this
    }
}