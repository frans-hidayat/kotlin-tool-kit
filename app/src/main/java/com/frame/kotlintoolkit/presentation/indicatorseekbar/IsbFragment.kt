package com.frame.kotlintoolkit.presentation.indicatorseekbar

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.frame.kotlintoolkit.R
import com.frame.kotlintoolkit.databinding.FragmentIsbBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IsbFragment : Fragment(R.layout.fragment_isb), View.OnClickListener {
    companion object {
        fun newInstance() = IsbFragment()
    }

    private val sType = arrayOf("continuous", "discrete", "custom", "java", "indicator", "donation")
    private val mFragmentList: ArrayList<Fragment> = ArrayList()
    private lateinit var binding: FragmentIsbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentIsbBinding.bind(view)

        initViews()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            else -> {

            }
        }
    }

    private fun initViews() {
        mFragmentList.add(ContinuousFragment())
        mFragmentList.add(DiscreteFragment())
        mFragmentList.add(CustomFragment())
        mFragmentList.add(JavaBuildFragment())
        mFragmentList.add(IndicatorFragment())

        binding.viewPager.adapter = IsbPagerAdapter(parentFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        for (s in sType) {
            val textView = TextView(requireContext())
            textView.text = s
            binding.tabLayout.newTab().customView = textView
        }
    }

    inner class IsbPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getCount(): Int {
            return mFragmentList.size
        }

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return sType[position]
        }
    }
}