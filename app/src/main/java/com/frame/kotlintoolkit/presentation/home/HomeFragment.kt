package com.frame.kotlintoolkit.presentation.home

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.frame.kotlintoolkit.R
import com.frame.kotlintoolkit.databinding.FragmentHomeBinding
import com.frame.kotlintoolkit.presentation.splashscreenapi.SplashScreenActivity


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.menuPlayground.setOnClickListener(this)
        binding.menuNotification.setOnClickListener(this)
        binding.menuLogin.setOnClickListener(this)
        binding.menuProductTour.setOnClickListener(this)
        binding.menuSplashscreenApi.setOnClickListener(this)
        binding.menuIndicatorSeekbar.setOnClickListener(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.menu_login -> openLogin()
            R.id.menu_notification -> openLogin()
            R.id.menu_playground -> openPlayground()
            R.id.menu_product_tour -> openProductTour()
            R.id.menu_splashscreen_api -> openSplashscreenApi()
            R.id.menu_indicator_seekbar -> openIndicatorSeekbar()
        }
    }

    private fun openSplashscreenApi() {
        val intent = Intent(requireContext(), SplashScreenActivity::class.java)
        requireActivity().startActivity(intent)
    }

    private fun openProductTour() {
        findNavController().navigate(R.id.action_HomeFragment_to_ProductTourFragment)
    }

    private fun openLogin() {
        findNavController().navigate(R.id.action_HomeFragment_to_LoginFragment)
    }

    private fun openPlayground() {
        findNavController().navigate(R.id.action_HomeFragment_to_PlaygroundFragment)
    }

    private fun openNotification() {
        val notificationLayout =
            RemoteViews(requireContext().packageName, R.layout.notification_small)

        var builder = NotificationCompat.Builder(requireContext(), "Test")
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setColor(Color.YELLOW)
            .setCustomContentView(notificationLayout)
            .setCustomBigContentView(notificationLayout)

        val notificationManager =
            requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "Test",
                "bima+",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(0, builder.build())
    }

    private fun openIndicatorSeekbar() {
        findNavController().navigate(R.id.action_HomeFragment_to_IsbFragment)
    }
}

