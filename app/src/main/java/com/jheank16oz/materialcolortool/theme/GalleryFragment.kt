package com.jheank16oz.materialcolortool.theme

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.jheank16oz.materialcolortool.R
import com.jheank16oz.materialcolortool.model.ImageModel
import kotlinx.android.synthetic.main.fragment_tabbed.view.*


/**
 *
 *  <p>PlaceHolderFragment</p>
 */
/**
 * A placeholder fragment containing a simple view.
 */
class GalleryFragment : Fragment() {

    var data: ArrayList<ImageModel> = ArrayList()

    private var images = arrayOf("https://images.unsplash.com/photo-1444090542259-0af8fa96557e?q=80&fm=jpg&w=1080&fit=max&s=4b703b77b42e067f949d14581f35019b", "https://images.unsplash.com/photo-1439546743462-802cabef8e97?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300", "https://images.unsplash.com/photo-1437651025703-2858c944e3eb?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300", "https://images.unsplash.com/photo-1431538510849-b719825bf08b?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300", "https://images.unsplash.com/photo-1434873740857-1bc5653afda8?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300", "https://images.unsplash.com/photo-1439396087961-98bc12c21176?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300", "https://images.unsplash.com/photo-1433616174899-f847df236857?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300", "https://images.unsplash.com/photo-1438480478735-3234e63615bb?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300", "https://images.unsplash.com/photo-1438027316524-6078d503224b?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_tabbed, container, false)

        data.clear()
        for (i in 0 until images.size) {
            data.add(ImageModel(images[i]))
        }

        rootView.list.layoutManager = GridLayoutManager(context, 3)
        rootView.list.setHasFixedSize(true)

        val mAdapter = GalleryAdapter(context!!, data)
        rootView.list.adapter = mAdapter

        rootView.list.addOnItemTouchListener(RecyclerItemClickListener(context!!,
                object : RecyclerItemClickListener.OnItemClickListener {

                    override fun onItemClick(view: View, position: Int) {
                        val intent = Intent(context, DetailActivity::class.java)
                        intent.putParcelableArrayListExtra("data", data)
                        intent.putExtra("pos", position)
                        startActivity(intent)
                    }
                }))
        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): GalleryFragment {
            val fragment = GalleryFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}