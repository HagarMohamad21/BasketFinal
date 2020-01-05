package net.zonetech.elbasket.Utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.util.TypedValue
import android.view.View
import com.booking.rtlviewpager.RtlViewPager
import com.example.basketrecyclerviewbased.Interfaces.OnReplaceLayoutRequest
import net.zonetech.elbasket.Activities.*
import net.zonetech.elbasket.Adapters.*
import net.zonetech.elbasket.Helpers.BottomNavHelper
import net.zonetech.elbasket.Helpers.Fonts
import net.zonetech.elbasket.Helpers.NavigationDrawerhelper
import net.zonetech.elbasket.Models.Offer
import net.zonetech.elbasket.R
import java.util.*
import java.util.List
import kotlin.collections.ArrayList


class CommonMethods(var c: Context) {
    fun setupFonts(view: View) {
        var  fonts = Fonts(c)
        fonts.Fonts()
        fonts.setTypeFce(view)
    }

    fun populateMainList(
        mainList: RecyclerView,
        layoutType: Int,
        onReplaceLayoutRequest: OnReplaceLayoutRequest,
        list: ArrayList<Offer>?
    ) {
        when (layoutType) {
            Common.LAYOUT_OFFER -> {
                var adapter: OffersAdapter
                adapter = OffersAdapter(c, list)

                adapter.onReplaceLayoutRequest = onReplaceLayoutRequest
                mainList.layoutManager = GridLayoutManager(c, 2)
                mainList.adapter = adapter
            }
            Common.LAYOUT_OFFER_DETAILS -> {

                var adapter = OfferDetailsAdapter(c, list)
                adapter.onReplaceLayoutRequest = onReplaceLayoutRequest
                mainList.layoutManager = LinearLayoutManager(c)
                mainList.adapter = adapter
            }
            Common.LAYOUT_CART -> {
                var adapter = CartAdapter(c)
                mainList.layoutManager = LinearLayoutManager(c)
                mainList.adapter = adapter
            }
            Common.LAYOUT_CATEGORY -> {
                var adapter = CategoryAdapter(Common.add(c), c)
                mainList.layoutManager = GridLayoutManager(c, 3)
                mainList.adapter = adapter
            }
            Common.LAYOUT_BEST_OFFER -> {
                var adapter = BestOffersAdapter(c, null)
                mainList.layoutManager =
                    LinearLayoutManager(c, LinearLayoutManager.HORIZONTAL, false)
                mainList.adapter = adapter
            }
            Common.LAYOUT_ACCOUNT_MENU -> {
                var adapter = MenuAdapter(c, Common.initList(c), layoutType)
                mainList.layoutManager = LinearLayoutManager(c)
                mainList.adapter = adapter
                mainList.addItemDecoration(ItemDecoration(c, ""))
            }
            Common.LAYOUT_DRAWER_MENU -> {
                var adapter = MenuAdapter(c, Common.initDrawerList(c), layoutType)
                adapter.onReplaceLayoutRequest = onReplaceLayoutRequest
                mainList.layoutManager = LinearLayoutManager(c)
                mainList.adapter = adapter
                mainList.addItemDecoration(ItemDecoration(c, "light"))
            }
            Common.LAYOUT_RATING -> {
                var adapter = RatingAdapter(c, LinearLayoutManager.VERTICAL)
                mainList.layoutManager = LinearLayoutManager(c)
                mainList.adapter = adapter
            }
            Common.DIALOG_IMAGE -> {
                mainList.layoutManager = LinearLayoutManager(c)
                var adapter = ImageChooserAdapter(c)
                mainList.adapter = adapter
                mainList.addItemDecoration(ItemDecoration(c, ""))
            }

        }


    }

    fun replaceLayout(fragmentNum: Int, layoutType: Int, navDrawerHelper: NavigationDrawerhelper) {
        var intent: Intent
        if (layoutType == Common.LAYOUT_DRAWER_MENU) {
            navDrawerHelper.toggleLeftDrawer()
            when (fragmentNum) {

                Common.ITEM_SUPER_MARKET -> {
                    c.open(MarketActivity(), null)
                }
                Common.ITEM_KITCHEN_SUPPLIES -> {
                    c.open(KitchenActivity(), null)
                }
                Common.ITEM_SCHOOL_SUPPLIES -> {
                    c.open(SchoolActivity(), null)
                }
                Common.ITEM_ELECTRONICS -> {
                    c.open(ElectronicsActivity(), null)
                }
                Common.ITEM_TOYS -> {
                    c.open(ToysActivity(), null)
                }
                Common.ITEM_COOKING -> {
                    c.open(CookingActivity(), null)
                }

            }
        } else if (layoutType == Common.LAYOUT_ACCOUNT_MENU) {
            when (fragmentNum) {
                Common.ITEM_ORDERS -> {
                }
                Common.ITEM_LIKES -> {
                }
                Common.ITEM_PERSONAL_INFO -> {
                }
                Common.ITEM_HEADLINES -> {
                }
                Common.ITEM_BREAKING_NEWS -> {
                }
                Common.ITEM_LANGUAGE -> {
                }
            }
        } else {
            c.open(OfferDetailsActivity(), null)
        }
    }





    fun ratingList(): ArrayList<String> {
        var ratingList=ArrayList<String>()
        ratingList.add(c.getString(R.string.excellent))
        ratingList.add(c.getString(R.string.very_good2))
        ratingList.add(c.getString(R.string.good))
        ratingList.add(c.getString(R.string.okay))
        ratingList.add(c.getString(R.string.bad))

   return ratingList
    }
}