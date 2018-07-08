package com.jheank16oz.materialcolortool.color

import android.os.Bundle
import com.jheank16oz.materialcolortool.BaseActivity
import com.jheank16oz.materialcolortool.R
import com.jheank16oz.materialcolortool.util.replaceFragmentInActivity

class ColorActivity : BaseActivity() {

    private lateinit var coloPresenter: ColorPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)


        val colorFragment =
                supportFragmentManager.findFragmentById(R.id.contentFrame) as ColorFragment?
                        ?: ColorFragment.newInstance().also {
                            replaceFragmentInActivity(it, R.id.contentFrame)
                        }

        // Create the presenter
        coloPresenter = ColorPresenter(colorFragment)
    }
}
