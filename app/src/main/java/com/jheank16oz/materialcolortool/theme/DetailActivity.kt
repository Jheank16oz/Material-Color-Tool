package com.jheank16oz.materialcolortool.theme

import android.animation.Animator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.jheank16oz.materialcolortool.R
import com.jheank16oz.materialcolortool.model.ImageModel


/**
 *
 *  <p>ActivityDetail</p>
 */
class DetailActivity : AppCompatActivity() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * [FragmentPagerAdapter] derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    var data: ArrayList<ImageModel> = ArrayList()
    private var pos: Int = 0

    internal lateinit var toolbar: Toolbar

    /**
     * The [ViewPager] that will host the section contents.
     */
    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        toolbar = findViewById(R.id.detail_toolbar)
        setSupportActionBar(toolbar)

        data = intent.getParcelableArrayListExtra<ImageModel>("data")
        pos = intent.getIntExtra("pos", 0)


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, data)
        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container)
        mViewPager?.setPageTransformer(true, DepthPageTransformer())

        mViewPager?.adapter = mSectionsPagerAdapter
        mViewPager?.currentItem = pos

        mViewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {


                //setTitle(data[position].getName())

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })


    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager, data: ArrayList<ImageModel>) : FragmentPagerAdapter(fm) {
        var data: ArrayList<ImageModel> = ArrayList()

        init {
            this.data = data
        }

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return DetailFragment.newInstance(position, data[position].url, data[position].url)
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return data.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return data[position].url
        }
    }


}