package com.jheank16oz.materialcolortool.selectcolor

import android.os.Bundle
import com.jheank16oz.materialcolortool.BaseActivity
import com.jheank16oz.materialcolortool.R
import com.jheank16oz.materialcolortool.util.replaceFragmentInActivity

class SelectColorActivity : BaseActivity() {

    private lateinit var selectColorPresenter: SelectColorPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_color)


        val selectColorFragment =
                supportFragmentManager.findFragmentById(R.id.contentFrame) as SelectColorFragment?
                        ?: SelectColorFragment.newInstance().also {
                            replaceFragmentInActivity(it, R.id.contentFrame)
                        }

        // Create the presenter
        selectColorPresenter = SelectColorPresenter(selectColorFragment)
    }
}
