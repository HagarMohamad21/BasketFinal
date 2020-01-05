package net.zonetech.elbasket.Utils

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

class CustomViewPager(c: Context, attributes: AttributeSet) : ViewPager(c,attributes) {
    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return true
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return true
    }
}