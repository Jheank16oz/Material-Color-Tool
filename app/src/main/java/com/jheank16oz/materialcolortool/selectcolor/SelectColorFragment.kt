package com.jheank16oz.materialcolortool.selectcolor

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jheank16oz.materialcolortool.R
import io.doist.recyclerviewext.sticky_headers.StickyHeadersLinearLayoutManager
import kotlinx.android.synthetic.main.selectcolor_frag.*
import kotlinx.android.synthetic.main.selectcolor_frag.view.*

class SelectColorFragment : Fragment(),SelectColorViewHolder.Callbacks, SelectColorContract.View {

    override lateinit var presenter: SelectColorContract.Presenter
    override var isActive = false
        get() = isAdded


    override fun onResume() {
        super.onResume()
        presenter.start()
    }


    private lateinit var mViewAdapter: SelectColorAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.selectcolor_frag, container, false)

        with(root) {
            //se initializa la lista
            list.addItemDecoration(DividerDecoration(context))
            list.setHasFixedSize(true)
            list.layoutManager = StickyHeadersLinearLayoutManager<SelectColorAdapter>(context)
            mViewAdapter = SelectColorAdapter(this@SelectColorFragment)
            list.adapter = mViewAdapter

            presenter.initializeData()
        }
        setHasOptionsMenu(true)
        return root
    }



    override fun displayData(data: ArrayList<Any>) {
        mViewAdapter.addAll(data)
    }

    override fun onColorClicked(colorId: Int) {

    }

    companion object {

        fun newInstance() =
                SelectColorFragment()
    }
}