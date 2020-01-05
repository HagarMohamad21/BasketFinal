package net.zonetech.elbasket.Utils

import android.app.Activity
import android.content.Context
import com.booking.rtlviewpager.RtlViewPager
import net.zonetech.elbasket.Helpers.BottomNavHelper

class ActivitiesCommonMethods(var context: Context) {

    fun overrideBackStack(
        pagerContainer: RtlViewPager,
        bottomNavHelper: BottomNavHelper,
        activity: Activity
    ) {
        if (bottomNavHelper.pageHistory.empty()) {
            activity.finish()
        } else {
            bottomNavHelper.pageHistory.pop()
            if (!bottomNavHelper.pageHistory.empty())
                pagerContainer.currentItem = bottomNavHelper.pageHistory.pop()
            else {
                activity.finish()
            }

        }
    }


}