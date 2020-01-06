package net.zonetech.elbasket.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.basketrecyclerviewbased.Interfaces.OnReplaceLayoutRequest
import kotlinx.android.synthetic.main.bottom_navigation_with_pager.*
import kotlinx.android.synthetic.main.fragment_offer_item.Dlayout
import kotlinx.android.synthetic.main.offer_detail_list_item.view.*
import kotlinx.android.synthetic.main.offer_item_content.*
import kotlinx.android.synthetic.main.offer_item_first_page.*
import kotlinx.android.synthetic.main.offer_item_second_page.*
import kotlinx.android.synthetic.main.offer_item_third_page.*
import kotlinx.android.synthetic.main.offer_item_upper_view.*
import kotlinx.android.synthetic.main.snippet_toolbar.*
import net.zonetech.elbasket.Adapters.RatingAdapter
import net.zonetech.elbasket.Adapters.SponsorAdapter
import net.zonetech.elbasket.Dialogs.CustomDialog
import net.zonetech.elbasket.Helpers.BottomNavHelper
import net.zonetech.elbasket.Helpers.NavigationDrawerhelper
import net.zonetech.elbasket.Helpers.RatingConfiguration
import net.zonetech.elbasket.Models.Offer
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.*


class OfferItemActivity : AppCompatActivity(), OnReplaceLayoutRequest {

    override fun replaceLayout(fragmentNum: Int, layoutType: Int) {
        if(fragmentNum== Common.ITEM_OFFER){
            pagerContainer.toggleVisiblity(true)
            mainContainer.toggleVisiblity(false)
            pagerContainer!!.setCurrentItem(1,false)

        }
        commonMethods.replaceLayout(fragmentNum,layoutType,navDrawerHelper)
    }
    lateinit var commonMethods: CommonMethods
    lateinit var navDrawerHelper: NavigationDrawerhelper
    lateinit var bottomNavHelper:BottomNavHelper
    lateinit var activitiesCommonMethods: ActivitiesCommonMethods
    var isFav:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_offer_item)
        activitiesCommonMethods=ActivitiesCommonMethods(this)
        initHelpers()
        setListeners()
        setupNavDrawer()
        initViews()
        populateLists()

    }

    private fun populateLists() {
        var adapter=RatingAdapter(this,LinearLayoutManager.HORIZONTAL)
        ratingsList.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        ratingsList.adapter=adapter
        var adapter2=SponsorAdapter(this)
        sponsorList.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        sponsorList.adapter=adapter2
    }
    private fun initViews() {
        if(intent.getStringExtra("Extras") == "TRUE"){
            discountTxt.toggleVisiblity(true)
           offerRibbonView.toggleVisiblity(true)
        }
          var offer=intent.getParcelableExtra<Offer>("Offer")
        if(offer!=null)
        {
            offerImage.setImageResource(offer.offerImage)
            offerName.text=offer.offerName
        }

    }

    private fun initHelpers() {
        bottomNavHelper= BottomNavHelper(mainContainer,pagerContainer,bottomNav,supportFragmentManager,1,this)
        bottomNavHelper.setupViewPager()
        navDrawerHelper= NavigationDrawerhelper(this,Dlayout,this)
       ratingTxt.text= RatingConfiguration.setupText(this,4f)

        commonMethods= CommonMethods(this)
        commonMethods.setupFonts(findViewById(android.R.id.content))


    }

    private fun setListeners() {
        ratingBtn.setOnClickListener {
           //open Dialog
            var customDialog=CustomDialog(this,null,Common.RATING_DIALOG)
            customDialog.show()
        }
        ratingsBrowseBtn.setOnClickListener {
             open(RatingActivity(),null)
        }
        favouriteBtn.setOnClickListener {
            if(!isFav){
               favouriteBtn.text =getString(R.string.filledHeart)
                isFav=true
            }
            else{
                isFav=false
                favouriteBtn.text =getString(R.string.heartIcon)
            }
        }
        cartBtn.setOnClickListener {
            //add to cart
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
}
