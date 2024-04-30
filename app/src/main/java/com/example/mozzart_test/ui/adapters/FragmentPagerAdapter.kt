package com.example.mozzart_test.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mozzart_test.ui.view.fragment.CouponFragment
import com.example.mozzart_test.ui.view.fragment.DrawLiveFragment
import com.example.mozzart_test.ui.view.fragment.ResultFragment
import com.example.mozzart_test.utils.Constants.FRAGMENT_TAB_COUNT
import com.example.mozzart_test.utils.Constants.FRAGMENT_TAB_COUPON_POSITION
import com.example.mozzart_test.utils.Constants.FRAGMENT_TAB_DRAW_POSITION
import com.example.mozzart_test.utils.Constants.FRAGMENT_TAB_INVALID_POSITION
import com.example.mozzart_test.utils.Constants.FRAGMENT_TAB_RESULT_POSITION


class FragmentPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int {
        return FRAGMENT_TAB_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            FRAGMENT_TAB_COUPON_POSITION -> CouponFragment()
            FRAGMENT_TAB_DRAW_POSITION -> DrawLiveFragment()
            FRAGMENT_TAB_RESULT_POSITION -> ResultFragment()
            else -> throw IllegalArgumentException(FRAGMENT_TAB_INVALID_POSITION)
        }
    }
}
