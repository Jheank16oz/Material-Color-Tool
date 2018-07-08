package com.jheank16oz.materialcolortool.color

import com.jheank16oz.materialcolortool.BasePresenter
import com.jheank16oz.materialcolortool.BaseView

interface ColorContract {

    interface View : BaseView<Presenter> {
        var isActive: Boolean
        fun showAddPrimaryColor()
        fun showAddSecondaryColor()

    }

    interface Presenter : BasePresenter {
    }
}