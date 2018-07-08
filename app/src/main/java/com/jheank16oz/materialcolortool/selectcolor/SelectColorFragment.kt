package com.jheank16oz.materialcolortool.selectcolor

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jheank16oz.materialcolortool.R
import kotlinx.android.synthetic.main.color_frag.view.*
import kotlinx.android.synthetic.main.selectcolor_frag.view.*

class SelectColorFragment : Fragment(), SelectColorContract.View {


    override lateinit var presenter: SelectColorContract.Presenter
    override var isActive = false
        get() = isAdded


    override fun onResume() {
        super.onResume()
        presenter.start()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.selectcolor_frag, container, false)
        with(root) {
            list.addItemDecoration(DividerDecoration(context))
            list.setHasFixedSize(true)
            list.setLayoutManager(
                    StickyHeadersLinearLayoutManager<ScheduleDayAdapter>(context))
            mViewAdapter = ScheduleDayAdapter(context, this, mTagMetadata, true)
            list.setAdapter(mViewAdapter)
        }
        setHasOptionsMenu(true)
        return root
    }

    companion object {

        fun newInstance() =
                SelectColorFragment()
    }


}