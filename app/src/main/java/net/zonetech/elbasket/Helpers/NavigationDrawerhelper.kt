package net.zonetech.elbasket.Helpers

import android.content.Context
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v4.widget.DrawerLayout
import com.example.basketrecyclerviewbased.Interfaces.OnReplaceLayoutRequest
import com.makeramen.roundedimageview.RoundedImageView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_account.view.*
import kotlinx.android.synthetic.main.header_layout.view.*
import kotlinx.android.synthetic.main.header_layout.view.profileImage
import kotlinx.android.synthetic.main.left_drawer_menu.view.*
import net.zonetech.elbasket.Models.Menu

import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.Common
import net.zonetech.elbasket.Utils.CommonMethods

class NavigationDrawerhelper(var c:Context,var Dlayout:DrawerLayout ,var onReplaceLayoutRequest:OnReplaceLayoutRequest)

{

    var list=ArrayList<Menu>()


    init {
        initList()
        var vector=VectorDrawableCompat.create(c.resources,R.drawable.ic_account,null)
        var profileImage=Dlayout.profileImage as RoundedImageView
        profileImage.setImageDrawable(vector)
    }

    private fun initList() {
        val menu1 = Menu(c.getString(R.string.offers), c.getString(R.string.offersIcon))
        val menu2 = Menu(c.getString(R.string.super_market), c.getString(R.string.basketIcon))
        val menu3 = Menu(c.getString(R.string.school_supplies),c.getString(R.string.pensIcon))
        val menu4 = Menu(c.getString(R.string.toys), c.getString(R.string.teddyBearIcon))
        val menu5 = Menu(c.getString(R.string.kitchen_supplies), c.getString(R.string.spoonsIcon     ))
        val menu6=Menu(c.getString(R.string.electronics),c.getString(R.string.plugIcon))
        val menu7 = Menu(c.getString(R.string.cooking), c.getString(R.string.microWaveIcon))
        list.clear()
        list.add(menu1)
        list.add(menu2)
        list.add(menu5)
        list.add(menu3)
        list.add(menu6)
        list.add(menu4)
        list.add(menu7)

        populateList()
    }

    private fun populateList() {
        var commonMethods=CommonMethods(c)
        commonMethods.populateMainList(
            Dlayout.navMenu,
            Common.LAYOUT_DRAWER_MENU,
            onReplaceLayoutRequest,
            null
        )
    }

     fun toggleLeftDrawer() {
        if (Dlayout.isDrawerOpen(Dlayout.leftDrawerMenu)) {
            Dlayout.closeDrawer(Dlayout.leftDrawerMenu)
        } else {
            Dlayout.openDrawer(Dlayout.leftDrawerMenu)
        }
    }

}
