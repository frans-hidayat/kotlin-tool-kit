package com.frame.kotlintoolkit.presentation.producttour

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.frame.kotlintoolkit.R
import com.frame.kotlintoolkit.databinding.FragmentProductTourBinding

class ProductTourFragment : Fragment(R.layout.fragment_product_tour) {
    companion object {
        @JvmStatic
        fun newInstance() =
            ProductTourFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    val NUM_PAGES = 4
    var isOpaque = true
    var pagerAdapter: ScreenSlidePagerAdapter? = null

    private lateinit var binding: FragmentProductTourBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductTourBinding.bind(view)

        val window: Window = requireActivity().window
        window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        )


        binding.skip.setOnClickListener {
            endTutorial()
        }
        binding.next.setOnClickListener {
            binding.pager.setCurrentItem(
                binding.pager.getCurrentItem() + 1,
                true
            )
        }
        binding.done.setOnClickListener {
            endTutorial()
        }

        pagerAdapter =
            ScreenSlidePagerAdapter(
                requireActivity().supportFragmentManager,
                lifecycle
            )
        binding.pager.adapter = pagerAdapter
        binding.pager.setPageTransformer(CrossFadePageTransformer())
        binding.pager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (position == NUM_PAGES - 2 && positionOffset > 0) {
                    if (isOpaque) {
                        binding.pager.setBackgroundColor(Color.TRANSPARENT)
                        isOpaque = false
                    }
                } else {
                    if (!isOpaque) {
                        binding.pager.setBackgroundColor(resources.getColor(com.google.android.material.R.color.primary_material_light))
                        isOpaque = true
                    }
                }
            }

            override fun onPageSelected(position: Int) {
                setIndicator(position)
                if (position == NUM_PAGES - 2) {
                    binding.skip.visibility = View.GONE
                    binding.next.visibility = View.GONE
                    binding.done.visibility = View.VISIBLE
                } else if (position < NUM_PAGES - 2) {
                    binding.skip.visibility = View.VISIBLE
                    binding.next.visibility = View.VISIBLE
                    binding.done.visibility = View.GONE
                } else if (position == NUM_PAGES - 1) {
                    endTutorial()
                }
            }
        })
        buildCircles()
    }

    override fun onDestroy() {
        super.onDestroy()

        binding.pager.clearDisappearingChildren()
    }

    private fun buildCircles() {
        val scale = resources.displayMetrics.density
        val padding = (5 * scale + 0.5f).toInt()
        for (i in 0 until NUM_PAGES - 1) {
            val circle = ImageView(requireContext())
            circle.setImageResource(R.drawable.ic_swipe_indicator_white_18dp)
            circle.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            circle.adjustViewBounds = true
            circle.setPadding(padding, 0, padding, 0)
            binding.circles.addView(circle)
        }
        setIndicator(0)
    }

    private fun setIndicator(index: Int) {
        if (index < NUM_PAGES) {
            for (i in 0 until NUM_PAGES - 1) {
                val circle = binding.circles.getChildAt(i) as ImageView
                if (i == index) {
                    circle.setColorFilter(resources.getColor(R.color.text_selected))
                } else {
                    circle.setColorFilter(resources.getColor(android.R.color.transparent))
                }
            }
        }
    }

    private fun endTutorial() {
        //finish()
        //overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
    }

    fun onBackPressed() {
        if (binding.pager.currentItem == 0) {
            requireActivity().onBackPressed()
        } else {
            binding.pager.currentItem = binding.pager.currentItem - 1
        }
    }

    inner class ScreenSlidePagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fm, lifecycle) {
        fun getItem(position: Int): Fragment? {
            var tp: ProductTourFragment? = null

            return tp
        }

        override fun getItemCount(): Int {
            return NUM_PAGES
        }

        override fun createFragment(position: Int): Fragment {
            var fragment: Fragment? = null
            when (position) {
                0 -> fragment = Fragment(R.layout.content_product_tour_1)
                1 -> fragment = Fragment(R.layout.content_product_tour_2)
                2 -> fragment = Fragment(R.layout.content_product_tour_3)
                3 -> fragment = Fragment(R.layout.content_product_tour_4)
            }
            return fragment!!
        }
    }

    inner class CrossFadePageTransformer : ViewPager2.PageTransformer {
        override fun transformPage(page: View, position: Float) {
            val pageWidth = page.width

            val backgroundView = page.findViewById<View>(R.id.welcome_fragment)
            val text_head = page.findViewById<View>(R.id.heading)
            val text_content = page.findViewById<View>(R.id.content)
            val object1 = page.findViewById<View>(R.id.a000)
            val object2 = page.findViewById<View>(R.id.a001)

            val object3 = page.findViewById<View>(R.id.a002)
            val object4 = page.findViewById<View>(R.id.a003)
            val object5 = page.findViewById<View>(R.id.a004)
            val object6 = page.findViewById<View>(R.id.a005)
            val object7 = page.findViewById<View>(R.id.a006)
            val object8 = page.findViewById<View>(R.id.a008)
            val object9 = page.findViewById<View>(R.id.a010)
            val object10 = page.findViewById<View>(R.id.a011)
            val object11 = page.findViewById<View>(R.id.a007)
            val object12 = page.findViewById<View>(R.id.a012)
            val object13 = page.findViewById<View>(R.id.a013)

            if (0 <= position && position < 1) {
                ViewHelper.setTranslationX(page, pageWidth * -position)
            }
            if (-1 < position && position < 0) {
                ViewHelper.setTranslationX(page, pageWidth * -position)
            }

            if (position <= -1.0f || position >= 1.0f) {
            } else if (position == 0.0f) {
            } else {
                if (backgroundView != null) {
                    ViewHelper.setAlpha(backgroundView, 1.0f - Math.abs(position))
                }
                if (text_head != null) {
                    ViewHelper.setTranslationX(text_head, pageWidth * position)
                    ViewHelper.setAlpha(text_head, 1.0f - Math.abs(position))
                }
                if (text_content != null) {
                    ViewHelper.setTranslationX(text_content, pageWidth * position)
                    ViewHelper.setAlpha(text_content, 1.0f - Math.abs(position))
                }
                if (object1 != null) {
                    ViewHelper.setTranslationX(object1, pageWidth * position)
                }

                // parallax effect
                if (object2 != null) {
                    ViewHelper.setTranslationX(object2, pageWidth * position)
                }
                if (object4 != null) {
                    ViewHelper.setTranslationX(object4, pageWidth / 2 * position)
                }
                if (object5 != null) {
                    ViewHelper.setTranslationX(object5, pageWidth / 2 * position)
                }
                if (object6 != null) {
                    ViewHelper.setTranslationX(object6, pageWidth / 2 * position)
                }
                if (object7 != null) {
                    ViewHelper.setTranslationX(object7, pageWidth / 2 * position)
                }
                if (object8 != null) {
                    ViewHelper.setTranslationX(object8, (pageWidth / 1.5 * position).toFloat())
                }
                if (object9 != null) {
                    ViewHelper.setTranslationX(object9, (pageWidth / 2 * position))
                }
                if (object10 != null) {
                    ViewHelper.setTranslationX(object10, pageWidth / 2 * position)
                }
                if (object11 != null) {
                    ViewHelper.setTranslationX(object11, (pageWidth / 1.2 * position).toFloat())
                }
                if (object12 != null) {
                    ViewHelper.setTranslationX(object12, (pageWidth / 1.3 * position).toFloat())
                }
                if (object13 != null) {
                    ViewHelper.setTranslationX(object13, (pageWidth / 1.8 * position).toFloat())
                }
                if (object3 != null) {
                    ViewHelper.setTranslationX(object3, (pageWidth / 1.2 * position).toFloat())
                }
            }
        }
    }

}