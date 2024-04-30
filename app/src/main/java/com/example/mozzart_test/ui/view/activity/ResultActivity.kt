package com.example.mozzart_test.ui.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mozzart_test.databinding.ActivityResultBinding
import com.example.mozzart_test.ui.adapters.FragmentPagerAdapter
import com.example.mozzart_test.utils.Constants
import com.example.mozzart_test.utils.Constants.TAB_COUPON_NAME
import com.example.mozzart_test.utils.Constants.TAB_DRAW_NAME
import com.example.mozzart_test.utils.Constants.TAB_RESULT_NAME
import com.google.android.material.tabs.TabLayoutMediator

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
    }


    private fun setupViewPager() {
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val pagerAdapter = FragmentPagerAdapter(this)
        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                Constants.FRAGMENT_TAB_COUPON_POSITION -> {
                    tab.text = TAB_COUPON_NAME
                    tab.setIcon(android.R.drawable.ic_menu_info_details)
                }

                Constants.FRAGMENT_TAB_DRAW_POSITION -> {
                    tab.text = TAB_DRAW_NAME
                    tab.setIcon(android.R.drawable.ic_media_play)
                }

                Constants.FRAGMENT_TAB_RESULT_POSITION -> {
                    tab.text = TAB_RESULT_NAME
                    tab.setIcon(android.R.drawable.ic_menu_camera)
                }
            }
        }.attach()
    }

}