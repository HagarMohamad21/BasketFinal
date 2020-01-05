package net.zonetech.elbasket.Utils

import android.content.Context
import android.util.TypedValue
import android.view.View
import net.zonetech.elbasket.Helpers.Fonts

class MarginOverrider(var c:Context) {
    var fonts: Fonts = Fonts(c)

    init {
        fonts.Fonts()
    }
    fun getPX(dp: Int): Int {
        val r = c.getResources()
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            r.getDisplayMetrics()
        ).toInt()
    }

    fun overrideMarginSides(view: View, start: Boolean) {

        if (start) {
            view.overrideStartMargin(getPX(0))
        } else if (!start) {
            view.overrideEndMargin(getPX(0))
        }
    }

    fun overrideMarginSidesForGridLayout(view: View, start: Boolean) {
        if (!fonts.isArabic) {
            if (start) {
                view.overrideLeftMargin(getPX(0))
            } else if (!start) {
                view.overrideRightMargin(getPX(0))
            }
        } else {
            if (start) {
                view.overrideRightMargin(getPX(0))
            } else if (!start) {
                view.overrideLeftMargin(getPX(0))
            }
        }
    }

    fun overrideMarginSides(view: View) {
        view.overrideLeftMargin(getPX(5))
        view.overrideRightMargin(getPX(5))

    }

    fun overrideMarginTop(view: View, Top: Int, bottom: Int) {
        view.overrideTopMargin(getPX(Top))
        view.overrideBottomMargin(getPX(bottom))
    }

}