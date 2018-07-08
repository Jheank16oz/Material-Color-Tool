package com.jheank16oz.materialcolortool.selectcolor

import com.jheank16oz.materialcolortool.BasePresenter
import com.jheank16oz.materialcolortool.BaseView

interface SelectColorContract {

    interface View : BaseView<Presenter> {
        var isActive: Boolean

    }

    interface Presenter : BasePresenter {
    }
}