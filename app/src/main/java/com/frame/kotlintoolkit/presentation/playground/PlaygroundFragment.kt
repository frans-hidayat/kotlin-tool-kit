package com.frame.kotlintoolkit.presentation.playground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.frame.kotlintoolkit.R
import com.frame.kotlintoolkit.databinding.FragmentPlaygroundBinding

class PlaygroundFragment : Fragment(R.layout.fragment_playground), View.OnClickListener {
    private var _binding: FragmentPlaygroundBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPlaygroundBinding.bind(view)

        binding.btnChangeColor.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btnChangeColor -> {
                binding.viewGraph.changeColor()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PlaygroundFragment().apply {

            }
    }
}