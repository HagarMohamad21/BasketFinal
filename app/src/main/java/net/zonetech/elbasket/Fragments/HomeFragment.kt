package net.zonetech.elbasket.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.offer_details_content.*
import net.zonetech.elbasket.Activities.*

import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.Common
import net.zonetech.elbasket.Utils.CommonMethods
import net.zonetech.elbasket.Utils.getCategories
import net.zonetech.elbasket.Utils.toggleVisiblity


class HomeFragment : Fragment() {
    private val TAG = "HomeFragment"
lateinit var commonMethods: CommonMethods
lateinit var homeFragment:View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        // Inflate the layout for this fragment
        homeFragment = inflater.inflate(R.layout.fragment_home, container, false)
        return homeFragment
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        commonMethods.setupFonts(this.view as ViewGroup)
    }

    fun initViews(){
        offerList.setNestedScrollingEnabled(false)
        commonMethods= CommonMethods(context!!)

        when (activity){
            is MainActivity->{

                    commonMethods.populateMainList(
                        homeFragment.categoryList,
                        Common.LAYOUT_CATEGORY,
                        activity as MainActivity,
                       null
                    )
                    commonMethods.populateMainList(
                        homeFragment.offerList,
                        Common.LAYOUT_BEST_OFFER,
                        activity as MainActivity,
                        null
                    )
            }

            is OfferDetailsActivity->{
                hideFilter()
                commonMethods.populateMainList(
                    homeFragment.categoryList,
                    Common.LAYOUT_CATEGORY,
                    activity as OfferDetailsActivity,
                    null
                )
                commonMethods.populateMainList(
                    homeFragment.offerList,
                    Common.LAYOUT_BEST_OFFER,
                    activity as OfferDetailsActivity,
                    null
                )
            }

            is OfferItemActivity->{
                commonMethods.populateMainList(
                    homeFragment.categoryList,
                    Common.LAYOUT_CATEGORY,
                    activity as OfferItemActivity,
                    null
                )
                commonMethods.populateMainList(
                    homeFragment.offerList,
                    Common.LAYOUT_BEST_OFFER,
                    activity as OfferItemActivity,
                    null
                )
            }

            is RatingActivity->{
                commonMethods.populateMainList(
                    homeFragment.categoryList,
                    Common.LAYOUT_CATEGORY,
                    activity as RatingActivity,
                    null
                )
                commonMethods.populateMainList(
                    homeFragment.offerList,
                    Common.LAYOUT_BEST_OFFER,
                    activity as RatingActivity,
                    null
                )
            }

            is MarketActivity->{
                commonMethods.populateMainList(
                    homeFragment.categoryList,
                    Common.LAYOUT_CATEGORY,
                    activity as MarketActivity,
                    null
                )
                commonMethods.populateMainList(
                    homeFragment.offerList,
                    Common.LAYOUT_BEST_OFFER,
                    activity as MarketActivity,
                    null
                )
            }

            is KitchenActivity->{
                commonMethods.populateMainList(
                    homeFragment.categoryList,
                    Common.LAYOUT_CATEGORY,
                    activity as KitchenActivity,
                    null
                )
                commonMethods.populateMainList(
                    homeFragment.offerList,
                    Common.LAYOUT_BEST_OFFER,
                    activity as KitchenActivity,
                    null
                )
            }

            is SchoolActivity->{
                commonMethods.populateMainList(
                    homeFragment.categoryList,
                    Common.LAYOUT_CATEGORY,
                    activity as SchoolActivity,
                    null
                )
                commonMethods.populateMainList(
                    homeFragment.offerList,
                    Common.LAYOUT_BEST_OFFER,
                    activity as SchoolActivity,
                    null
                )
            }

            is ElectronicsActivity->{
                commonMethods.populateMainList(
                    homeFragment.categoryList,
                    Common.LAYOUT_CATEGORY,
                    activity as ElectronicsActivity,
                    null
                )
                commonMethods.populateMainList(
                    homeFragment.offerList,
                    Common.LAYOUT_BEST_OFFER,
                    activity as ElectronicsActivity,
                    null
                )
            }

            is ToysActivity->{
                commonMethods.populateMainList(
                    homeFragment.categoryList,
                    Common.LAYOUT_CATEGORY,
                    activity as ToysActivity,
                    null
                )
                commonMethods.populateMainList(
                    homeFragment.offerList,
                    Common.LAYOUT_BEST_OFFER,
                    activity as ToysActivity,
                    null
                )
            }

            is CookingActivity->{
                commonMethods.populateMainList(
                    homeFragment.categoryList,
                    Common.LAYOUT_CATEGORY,
                    activity as CookingActivity,
                    null
                )
                commonMethods.populateMainList(
                    homeFragment.offerList,
                    Common.LAYOUT_BEST_OFFER,
                    activity as CookingActivity,
                    null
                )
            }



        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }
    private fun hideFilter() {
        activity!!.filterTxt.toggleVisiblity(false)
        activity!!.filterIcon.toggleVisiblity(false)
    }


}
