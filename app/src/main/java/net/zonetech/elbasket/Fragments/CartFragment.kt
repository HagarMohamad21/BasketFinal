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
import net.zonetech.elbasket.Utils.MarginOverrider
import net.zonetech.elbasket.Utils.toggleVisiblity

class CartFragment : Fragment() {
    private val TAG = "CartFragment"
lateinit var commonMethods: CommonMethods
lateinit var marginOverrider:MarginOverrider

lateinit var cartFragment:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ****")
        cartFragment= inflater.inflate(R.layout.recyclerview_fragment, container, false)
        commonMethods= CommonMethods(context!!)
        marginOverrider=MarginOverrider(context!!)

        when (activity){
            is MainActivity->{
                commonMethods.populateMainList(
                    cartFragment.mainList,
                    Common.LAYOUT_CART,
                    activity as MainActivity,
                    null
                )

            }

            is OfferDetailsActivity ->{
                hideFilter()
                commonMethods.populateMainList(
                    cartFragment.mainList,
                    Common.LAYOUT_CART,
                    activity as OfferDetailsActivity,
                    null
                )

            }
            is OfferItemActivity ->{
                commonMethods.populateMainList(
                    cartFragment.mainList,
                    Common.LAYOUT_CART,
                    activity as OfferItemActivity,
                    null
                )
            }

            is RatingActivity ->{
                commonMethods.populateMainList(
                    cartFragment.mainList,
                    Common.LAYOUT_CART,
                    activity as RatingActivity,
                    null
                )
            }

            is MarketActivity ->{
                commonMethods.populateMainList(
                    cartFragment.mainList,
                    Common.LAYOUT_CART,
                    activity as MarketActivity,
                    null
                )
            }

            is KitchenActivity ->{
                commonMethods.populateMainList(
                    cartFragment.mainList,
                    Common.LAYOUT_CART,
                    activity as KitchenActivity,
                    null
                )
            }

            is SchoolActivity ->{
                commonMethods.populateMainList(
                    cartFragment.mainList,
                    Common.LAYOUT_CART,
                    activity as SchoolActivity,
                    null
                )
            }

            is ElectronicsActivity ->{
                commonMethods.populateMainList(
                    cartFragment.mainList,
                    Common.LAYOUT_CART,
                    activity as ElectronicsActivity,
                    null
                )
            }
            is ToysActivity ->{
                commonMethods.populateMainList(
                    cartFragment.mainList,
                    Common.LAYOUT_CART,
                    activity as ToysActivity,
                    null
                )
            }
            is CookingActivity ->{
                commonMethods.populateMainList(
                    cartFragment.mainList,
                    Common.LAYOUT_CART,
                    activity as CookingActivity,
                    null
                )
            }

        }
        return cartFragment
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        commonMethods.setupFonts(this.view as ViewGroup)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }
    private fun initViews() {
        var prams= submitBtn.getLayoutParams() as ViewGroup.MarginLayoutParams
        prams.bottomMargin=marginOverrider.getPX(10)
        submitBtn.layoutParams=prams
    }

    private fun hideFilter() {
        activity!!.filterTxt.toggleVisiblity(false)
        activity!!.filterIcon.toggleVisiblity(false)
    }
}
