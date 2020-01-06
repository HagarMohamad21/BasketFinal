package net.zonetech.elbasket.Utils

import android.content.Context
import android.util.Log
import net.zonetech.elbasket.Models.Category
import net.zonetech.elbasket.Models.Menu
import net.zonetech.elbasket.Models.Offer
import net.zonetech.elbasket.R


class Common {
    companion object{
        const val RATING_DIALOG=10
        const val DIALOG_IMAGE=9
        const val LAYOUT_RATING=8
        val SELECTED_LANGUAGE=""
        const val LAYOUT_CART=1
        const val LAYOUT_OFFER=2
        const val LAYOUT_OFFER_DETAILS=3
        const val LAYOUT_ACCOUNT_MENU=4
        const val LAYOUT_CATEGORY=5
        const val LAYOUT_BEST_OFFER=6
        const val LAYOUT_DRAWER_MENU=7
        const val FRAGMENT_OFFER_DETAILS=20
        const val FRAGMENT_OFFER_ITEM=21


        fun initList(context: Context) :ArrayList<Menu> {

            var accountList=ArrayList<Menu>()
            val menu1 = Menu(context.getString(R.string.orders), context.getString(R.string.vanIcon))
            val menu2 = Menu(context.getString(R.string.wishlist), context.getString(R.string.heartIcon))
            val menu3 = Menu(context.getString(R.string.personal_info), context.getString(R.string.accountStarIcon))
            val menu4 = Menu(context.getString(R.string.headlines), context.getString(R.string.headlinesIcon))
            val menu5 = Menu(context.getString(R.string.breaking_news), context.getString(R.string.calendarIcon))
            val menu6 = Menu(context.getString(R.string.language), context.getString(R.string.earthIcon))
            accountList.clear()
            accountList.add(menu1)
            accountList.add(menu2)
            accountList.add(menu3)
            accountList.add(menu4)
            accountList.add(menu5)
            accountList.add(menu6)

            return accountList
        }

        fun initDrawerList(c:Context):ArrayList<Menu> {
            var drawerList=ArrayList<Menu>()
            val menu1 = Menu(c.getString(R.string.offers), c.getString(R.string.offersIcon))
            val menu2 = Menu(c.getString(R.string.super_market), c.getString(R.string.basketIcon))
            val menu3 = Menu(c.getString(R.string.school_supplies),c.getString(R.string.pensIcon))
            val menu4 = Menu(c.getString(R.string.toys), c.getString(R.string.teddyBearIcon))
            val menu5 = Menu(c.getString(R.string.kitchen_supplies), c.getString(R.string.spoonsIcon     ))
            val menu6=Menu(c.getString(R.string.electronics),c.getString(R.string.plugIcon))
            val menu7 = Menu(c.getString(R.string.cooking), c.getString(R.string.microWaveIcon))

            drawerList.clear()
            drawerList.add(menu1)
            drawerList.add(menu2)
            drawerList.add(menu5)
            drawerList.add(menu3)
            drawerList.add(menu6)
            drawerList.add(menu4)
            drawerList.add(menu7)

            return drawerList
        }

        fun initImageChooser(context: Context):ArrayList<String>{
           var imageChooser=ArrayList<String>()
            imageChooser.add(context.getString(R.string.camera))
            imageChooser.add(context.getString(R.string.gallery))
            return imageChooser
        }


//******************************************************DRAWER MENU ITEMS NUMBERS *******************************************************//

        const val ITEM_OFFER=0
        const val ITEM_SUPER_MARKET=1
        const val ITEM_KITCHEN_SUPPLIES=2
        const val ITEM_SCHOOL_SUPPLIES=3
        const val ITEM_ELECTRONICS=4
        const val ITEM_TOYS=5
        const val ITEM_COOKING=6

//***************************************************** ACCOUNT MENU ITEMS NUMBERS **************************************************//

        const val ITEM_ORDERS=0
        const val ITEM_LIKES=1
        const val ITEM_PERSONAL_INFO=2
        const val ITEM_HEADLINES=3
        const val ITEM_BREAKING_NEWS=4
        const val ITEM_LANGUAGE=5

        private val TAG = "Common"

    }

    //************************************************************OFFER CATEGORY ******************************************************

}