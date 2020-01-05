package net.zonetech.elbasket.Utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import net.zonetech.elbasket.R

class ItemDecoration constructor(context: Context,var divColor:String) : RecyclerView.ItemDecoration() {
    var mDivider: Drawable

    init {
        if(divColor.equals("light")){
            mDivider = context.resources.getDrawable(R.drawable.recycler_horizontal_divider_light)

        }
        else
            mDivider = context.resources.getDrawable(R.drawable.recycler_horizontal_divider)
    }




    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0..childCount - 2) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider.intrinsicHeight

            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(c)
        }
    }}