package com.jheank16oz.materialcolortool.selectcolor


class SelectColorPresenter(private val selectColorView: SelectColorContract.View) : SelectColorContract.Presenter {

    override fun start() {
        //ignored
    }

    init {
        selectColorView.presenter = this
    }
}