package net.zonetech.elbasket.Fragments


import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.offer_details_content.*
import net.zonetech.elbasket.Activities.OfferDetailsActivity
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.CommonMethods
import net.zonetech.elbasket.Utils.toggleVisiblity


class SearchFragment : Fragment() {
    private val TAG = "SearchFragment"
lateinit var searchFragment:View
lateinit var commonMethods: CommonMethods
    override fun onCreateView(
        
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        // Inflate the layout for this fragment
        searchFragment= inflater.inflate(R.layout.fragment_search, container, false)
        if (activity is OfferDetailsActivity){
            hideFilter()
        }
        return searchFragment
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        commonMethods= CommonMethods(context!!)
        commonMethods.setupFonts(this.view as ViewGroup)
    }
    private fun hideFilter() {
        activity!!.filterTxt.toggleVisiblity(false)
        activity!!.filterIcon.toggleVisiblity(false)
    }

}
