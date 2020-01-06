package net.zonetech.elbasket.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.offer_details_content.*
import kotlinx.android.synthetic.main.recyclerview_fragment.*
import kotlinx.android.synthetic.main.recyclerview_fragment.view.*
import net.zonetech.elbasket.Activities.*

import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.Common
import net.zonetech.elbasket.Utils.CommonMethods
import net.zonetech.elbasket.Utils.getOffers
import net.zonetech.elbasket.Utils.toggleVisiblity


class OffersFragment : Fragment() {

    private val TAG = "OffersFragment"
    lateinit var commonMethods: CommonMethods
    lateinit var offerFragment:View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        // Inflate the layout for this fragment
        offerFragment= inflater.inflate(R.layout.recyclerview_fragment, container, false)
        commonMethods= CommonMethods(context!!)
        when (activity){
            is MainActivity->{

                commonMethods.populateMainList(
                    offerFragment.mainList,
                    Common.LAYOUT_OFFER,
                    activity as MainActivity,
                    getOffers()
                )

            }

            is OfferDetailsActivity ->{
                hideFilter()
                commonMethods.populateMainList(
                    offerFragment.mainList,
                    Common.LAYOUT_OFFER,
                    activity as OfferDetailsActivity,
                    null
                )

            }
            is OfferItemActivity ->{
                commonMethods.populateMainList(
                    offerFragment.mainList,
                    Common.LAYOUT_OFFER,
                    activity as OfferItemActivity,
                    null
                )

            }

            is RatingActivity ->{
                commonMethods.populateMainList(
                    offerFragment.mainList,
                    Common.LAYOUT_OFFER,
                    activity as RatingActivity,
                    null
                )

            }

            is MarketActivity ->{
                commonMethods.populateMainList(
                    offerFragment.mainList,
                    Common.LAYOUT_OFFER,
                    activity as MarketActivity,
                    null
                )

            }

            is KitchenActivity ->{
                commonMethods.populateMainList(
                    offerFragment.mainList,
                    Common.LAYOUT_OFFER,
                    activity as KitchenActivity,
                    null
                )

            }

            is SchoolActivity ->{
                commonMethods.populateMainList(
                    offerFragment.mainList,
                    Common.LAYOUT_OFFER,
                    activity as SchoolActivity,
                    null
                )

            }

            is ElectronicsActivity ->{
                commonMethods.populateMainList(
                    offerFragment.mainList,
                    Common.LAYOUT_OFFER,
                    activity as ElectronicsActivity,
                    null
                )

            }
            is ToysActivity ->{
                commonMethods.populateMainList(
                    offerFragment.mainList,
                    Common.LAYOUT_OFFER,
                    activity as ToysActivity,
                    null
                )

            }
            is CookingActivity ->{
                commonMethods.populateMainList(
                    offerFragment.mainList,
                    Common.LAYOUT_OFFER,
                    activity as CookingActivity,
                    null
                )

            }


        }
        return offerFragment

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitBtn.toggleVisiblity(false)
    }

    private fun hideFilter() {
        activity!!.filterTxt.toggleVisiblity(false)
        activity!!.filterIcon.toggleVisiblity(false)
    }
}
