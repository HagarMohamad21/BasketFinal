package net.zonetech.elbasket.Fragments


import android.os.Bundle
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_account.view.*
import kotlinx.android.synthetic.main.offer_details_content.*
import net.zonetech.elbasket.Activities.*
import net.zonetech.elbasket.Dialogs.CustomDialog
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.Common
import net.zonetech.elbasket.Utils.CommonMethods
import net.zonetech.elbasket.Utils.toggleVisiblity


class AccountFragment : Fragment() {
    private val TAG = "AccountFragment"
    lateinit var accountFragment:View
    lateinit var commonMethods: CommonMethods
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")

        accountFragment = inflater.inflate(R.layout.fragment_account, container, false)
        commonMethods= CommonMethods(context!!)
        when (activity){
            is MainActivity->{
                commonMethods.populateMainList(
                    accountFragment.accountList,
                    Common.LAYOUT_ACCOUNT_MENU,
                    activity as MainActivity,
                    null
                ) }

            is OfferDetailsActivity ->{
                hideFilter()
                commonMethods.populateMainList(
                    accountFragment.accountList,
                    Common.LAYOUT_ACCOUNT_MENU,
                    activity as OfferDetailsActivity,
                    null
                )

            }
            is OfferItemActivity ->{
                commonMethods.populateMainList(
                    accountFragment.accountList,
                    Common.LAYOUT_ACCOUNT_MENU,
                    activity as OfferItemActivity,
                    null
                )

            }

            is RatingActivity ->{
                commonMethods.populateMainList(
                    accountFragment.accountList,
                    Common.LAYOUT_ACCOUNT_MENU,
                    activity as RatingActivity,
                    null
                )

            }

            is MarketActivity ->{
                commonMethods.populateMainList(
                    accountFragment.accountList,
                    Common.LAYOUT_ACCOUNT_MENU,
                    activity as MarketActivity,
                    null
                )

            }

            is KitchenActivity ->{
                commonMethods.populateMainList(
                    accountFragment.accountList,
                    Common.LAYOUT_ACCOUNT_MENU,
                    activity as KitchenActivity,
                    null
                )

            }

            is SchoolActivity ->{
                commonMethods.populateMainList(
                    accountFragment.accountList,
                    Common.LAYOUT_ACCOUNT_MENU,
                    activity as SchoolActivity,
                    null
                )

            }

            is ElectronicsActivity ->{
                commonMethods.populateMainList(
                    accountFragment.accountList,
                    Common.LAYOUT_ACCOUNT_MENU,
                    activity as ElectronicsActivity,
                    null
                )

            }
            is ToysActivity ->{
                commonMethods.populateMainList(
                    accountFragment.accountList,
                    Common.LAYOUT_ACCOUNT_MENU,
                    activity as ToysActivity,
                    null
                )

            }
            is CookingActivity ->{
                commonMethods.populateMainList(
                    accountFragment.accountList,
                    Common.LAYOUT_ACCOUNT_MENU,
                    activity as CookingActivity,
                    null
                )

            }

        }
        return accountFragment
    }

    private fun hideFilter() {
        activity!!.filterTxt.toggleVisiblity(false)
        activity!!.filterIcon.toggleVisiblity(false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        commonMethods.setupFonts(this.view as ViewGroup)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setListeners()
    }

    private fun initViews() {
        var vector= VectorDrawableCompat.create(context!!.resources,R.drawable.ic_account,null)
        profileImage.setImageDrawable(vector)
    }


    private fun setListeners() {
        profileImage.setOnClickListener {
            //show dialog
            CustomDialog(context!!,getString(R.string.choose_image),Common.DIALOG_IMAGE).show()
        }
    }
}
