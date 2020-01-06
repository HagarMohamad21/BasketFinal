package net.zonetech.elbasket.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.basketrecyclerviewbased.Interfaces.OnReplaceLayoutRequest
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_navigation_with_pager.*
import kotlinx.android.synthetic.main.offer_details_content.*
import kotlinx.android.synthetic.main.recyclerview_fragment.mainList
import kotlinx.android.synthetic.main.snippet_toolbar.*
import net.zonetech.elbasket.Helpers.BottomNavHelper
import net.zonetech.elbasket.Helpers.NavigationDrawerhelper
import net.zonetech.elbasket.Models.Offer
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.*

class OfferDetailsActivity : AppCompatActivity(), OnReplaceLayoutRequest {

    lateinit var bottomNavHelper:BottomNavHelper
    private var offers=ArrayList<Offer>()

    override fun replaceLayout(fragmentNum: Int,layoutType:Int) {
        if(fragmentNum==Common.ITEM_OFFER){
            pagerContainer.toggleVisiblity(true)
            mainList.toggleVisiblity(false)
            pagerContainer!!.setCurrentItem(1,false)

        }
        commonMethods.replaceLayout(fragmentNum,layoutType,navDrawerHelper)
        if (fragmentNum==Common.FRAGMENT_OFFER_ITEM){
            intent = Intent(this,OfferItemActivity::class.java)
            startActivity(intent)
        }

    }
    lateinit var navDrawerHelper: NavigationDrawerhelper
    lateinit var commonMethods: CommonMethods
    lateinit var activitiesCommonMethods: ActivitiesCommonMethods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer_details)
        activitiesCommonMethods=ActivitiesCommonMethods(this)
        initHelpers()
        setupNavDrawer()


    }

    private fun initViews(extraData: Offer) {
        var filterString=getString(R.string._50_items_available)+" ("+extraData.offerName+")"
        filterTxt.text=filterString
    }

    private fun initHelpers() {
        bottomNavHelper=BottomNavHelper(mainList,pagerContainer,bottomNav,supportFragmentManager,0,this)
        bottomNavHelper.setupViewPager()
        navDrawerHelper= NavigationDrawerhelper(this,Dlayout,this)
        commonMethods= CommonMethods(this)
        commonMethods.setupFonts(findViewById(android.R.id.content))
        val extraData=intent.getParcelableExtra<Offer>("Offer")
        if (extraData != null) {
            initViews(extraData)
            initOffers(extraData)
            commonMethods.populateMainList(mainList, Common.LAYOUT_OFFER_DETAILS, this, offers)
        }

    }

    private fun setupNavDrawer() {
        menuBtn.setOnClickListener {
            navDrawerHelper.toggleLeftDrawer()
        }
    }


    override fun onBackPressed() {
        activitiesCommonMethods.overrideBackStack(pagerContainer,bottomNavHelper,this)

    }

    private fun initOffers(offerCategory:Offer):ArrayList<Offer>{
        Log.d("initOffers","++++++++++++++++++++++++++++++++++++++"+offerCategory.offerName)
        offers.clear()
        when(offerCategory.offerName){
            "Kids"->
                offers= getKids()
            "Clothes"->
                offers= getClothes()
            "School supplies"->
                offers= getSchool()
            "Electronics"->
                offers= getElectronics()
            "Smart phones"->
                offers= getPhones()
            "Super market"->
                offers= getOffers()
        }
        return offers
    }
}