package com.jheank16oz.materialcolortool.color

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jheank16oz.materialcolortool.R
import kotlinx.android.synthetic.main.color_frag.view.*

class ColorFragment : Fragment(), ColorContract.View {


    override lateinit var presenter: ColorContract.Presenter
    override var isActive = false
        get() = isAdded


    override fun onResume() {
        super.onResume()
        presenter.start()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.color_frag, container, false)
        with(root) {
            primary.setOnClickListener {
                showAddPrimaryColor()
            }

        }
        setHasOptionsMenu(true)
        return root
    }

    companion object {

        fun newInstance() =
                ColorFragment()
    }

    override fun showAddPrimaryColor() {
    }

    override fun showAddSecondaryColor() {
    }
}