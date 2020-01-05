package net.zonetech.elbasket.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.basketrecyclerviewbased.Interfaces.OnReplaceLayoutRequest
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_navigation_with_pager.*
import kotlinx.android.synthetic.main.header_layout.*
import kotlinx.android.synthetic.main.offer_item_content.*
import kotlinx.android.synthetic.main.snippet_toolbar.*
import net.zonetech.elbasket.Helpers.BottomNavHelper
import net.zonetech.elbasket.Helpers.NavigationDrawerhelper
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.ActivitiesCommonMethods
import net.zonetech.elbasket.Utils.Common
import net.zonetech.elbasket.Utils.CommonMethods
import net.zonetech.elbasket.Utils.toggleVisiblity

class ElectronicsActivity : AppCompatActivity() , OnReplaceLayoutRequest {
    private val TAG = "ElectronicsActivity"
    lateinit var navDrawerHelper: NavigationDrawerhelper
    lateinit var commonMethods: CommonMethods
    lateinit var activitiesCommonMethods: ActivitiesCommonMethods
    lateinit var bottomNavHelper: BottomNavHelper
    override fun replaceLayout(fragmentNum:Int,layoutType:Int) {
        if(fragmentNum== Common.ITEM_OFFER){
            pagerContainer.toggleVisiblity(true)
            mainContainer.toggleVisiblity(false)
            pagerContainer!!.setCurrentItem(1,false)

        }
        commonMethods.replaceLayout(fragmentNum,layoutType,navDrawerHelper)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_activity)
        activitiesCommonMethods=ActivitiesCommonMethods(this)
        initHelpers()
        setupNavDrawer()
    }

    private fun initHelpers() {
        bottomNavHelper= BottomNavHelper(mainContainer,pagerContainer,bottomNav,supportFragmentManager,-1,this)
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
