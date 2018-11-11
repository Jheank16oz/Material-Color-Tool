package com.jheank16oz.materialcolortool.theme

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.jheank16oz.materialcolortool.R
import kotlinx.android.synthetic.main.fragment_detail.view.*

/**
 *
 *  <p>DetailFragment</p>
 */
/**
 * A placeholder fragment containing a simple view.
 */
class DetailFragment : Fragment() {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */

    internal var name: String? = null
    private var url: String? = null
    private var pos: Int = 0

    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        this.pos = args!!.getInt(ARG_SECTION_NUMBER)
        this.name = args.getString(ARG_IMG_TITLE)
        this.url = args.getString(ARG_IMG_URL)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)


        Log.e("url", url)
        activity?.let {
            Glide.with(it)
                    .load(url)
                    .thumbnail(0.1f)
                    .into(rootView.photo_view)
        }

        return rootView
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        private const val ARG_IMG_TITLE = "image_title"
        private const val ARG_IMG_URL = "image_url"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int, name: String, url: String): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            args.putString(ARG_IMG_TITLE, name)
            args.putString(ARG_IMG_URL, url)
            fragment.arguments = args
            return fragment
        }
    }
}
