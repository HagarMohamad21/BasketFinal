package net.zonetech.elbasket.Helpers

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import net.zonetech.elbasket.R
import android.widget.TextView
import net.zonetech.elbasket.Utils.CommonMethods


class TabViewHelper(var c:Context) {
    private var tabArrayTitle=ArrayList<Int>()
    private var tabArrayIcons=ArrayList<Int>()
  val fonts = Fonts(c)

    fun initTabsArrays()
    { fonts.Fonts()
      tabArrayTitle.add(R.string.home)
      tabArrayIcons.add(R.string.homeIcon)
      tabArrayTitle.add(R.string.offers)
      tabArrayIcons.add(R.string.offersIcon)
      tabArrayTitle.add(R.string.search)
      tabArrayIcons.add(R.string.searchIcon)
      tabArrayTitle.add(R.string.cart)
      tabArrayIcons.add(R.string.cartIcon)
      tabArrayTitle.add(R.string.account)
      tabArrayIcons.add(R.string.accountIcon)
    }

    fun getTabView(position: Int): View {

        val v = LayoutInflater.from(c).inflate(R.layout.tab_item, null)
        val tabIcon=v.findViewById(R.id.tabIcon) as TextView
        val tabTitle = v.findViewById(R.id.tabTitle) as TextView
        val tabRoot=v.findViewById(R.id.tabRoot) as LinearLayout
        //tabIcon.typeface=fonts.iconsFont
        tabTitle.setText(c.getString(tabArrayTitle[position]))
        tabIcon.setText(c.getString(tabArrayIcons[position]))
        return v
    }


}