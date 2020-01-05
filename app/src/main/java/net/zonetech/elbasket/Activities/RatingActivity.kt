package net.zonetech.elbasket.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.basketrecyclerviewbased.Interfaces.OnReplaceLayoutRequest
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_navigation_with_pager.*
import kotlinx.android.synthetic.main.offer_item_content.*
import kotlinx.android.synthetic.main.recyclerview_fragment.*
import kotlinx.android.synthetic.main.snippet_toolbar.*
import net.zonetech.elbasket.Helpers.BottomNavHelper
import net.zonetech.elbasket.Helpers.NavigationDrawerhelper
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.ActivitiesCommonMethods
import net.zonetech.elbasket.Utils.Common
import net.zonetech.elbasket.Utils.CommonMethods
import net.zonetech.elbasket.Utils.toggleVisiblity


class RatingActivity : AppCompatActivity(),OnReplaceLayoutRequest {
    private val TAG = "RatingActivity"
    override fun replaceLayout(fragmentNum: Int, layoutType: Int) {
        if(fragmentNum==Common.ITEM_OFFER){
            pagerContainer.toggleVisiblity(true)
            mainList.toggleVisiblity(false)
            pagerContainer!!.setCurrentItem(1,false)

        }
        commonMethods.replaceLayout(fragmentNum,layoutType,navDrawerHelper)
    }
    lateinit var commonMethods: CommonMethods
    lateinit var navDrawerHelper:NavigationDrawerhelper
    lateinit var bottomNavHelper: BottomNavHelper
    lateinit var activitiesCommonMethods: ActivitiesCommonMethods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)
        activitiesCommonMethods=ActivitiesCommonMethods(this)
        initHelpers()
        setupNavDrawer()
        populateList()
    }


    private fun populateList() {
    commonMethods.populateMainList(mainList, Common.LAYOUT_RATING, this, null)
    }

    private fun initHelpers() {
        bottomNavHelper=
            BottomNavHelper(mainList,pagerContainer,bottomNav,supportFragmentManager,1,this)
        bottomNavHelper.setupViewPager()
        commonMethods= CommonMethods(this)
        commonMethods.setupFonts(findViewById(android.R.id.content))
        navDrawerHelper= NavigationDrawerhelper(this,Dlayout,this)

    }



    private fun setupNavDrawer() {
        menuBtn.setOnClickListener {
            navDrawerHelper.toggleLeftDrawer()
        }

    }

    override fun onBackPressed() {
        activitiesCommonMethods.overrideBackStack(pagerContainer,bottomNavHelper,this)
    }
}
