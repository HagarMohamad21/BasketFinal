package net.zonetech.elbasket.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basketrecyclerviewbased.Interfaces.OnReplaceLayoutRequest
import kotlinx.android.synthetic.main.offer_list_item.view.*
import net.zonetech.elbasket.Activities.OfferDetailsActivity
import net.zonetech.elbasket.Activities.OfferItemActivity
import net.zonetech.elbasket.Models.Offer
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.CommonMethods
import net.zonetech.elbasket.Utils.MarginOverrider
import net.zonetech.elbasket.Utils.open

class OffersAdapter(var context: Context,var offers:ArrayList<Offer>?) : RecyclerView.Adapter<OffersAdapter.OffersViewHolder>() {

     var onReplaceLayoutRequest:OnReplaceLayoutRequest?=null
    var commonMethods= CommonMethods(context)
    var marginOverrider= MarginOverrider(context)

    var hasRibbon="TRUE"
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): OffersViewHolder {
     val view:View=LayoutInflater.from(context).inflate(R.layout.offer_list_item,p0,false)
        return OffersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(p0: OffersViewHolder, p1: Int) {

        p0.bind(p1)
    }


    inner class OffersViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        private var offerTitle:String?=null
        fun bind(pos:Int) {
            commonMethods.setupFonts(itemView)

            if (offers != null) {
                offerTitle=offers!![0].offerCategory
                itemView.offerName.text= offerTitle

            }

            itemView.offerImage.setOnClickListener {
               context.open(OfferItemActivity(),hasRibbon)
            }

            overrideMargins(pos)
        }




        private fun overrideMargins(
            pos: Int
        ) {
            if(pos%2==0){
                marginOverrider.overrideMarginSidesForGridLayout(itemView,true)
            }
            else{
                marginOverrider.overrideMarginSidesForGridLayout(itemView,false)
            }

            if(pos==0||pos==1){
                marginOverrider.overrideMarginTop(itemView,0,5)

            }
            else if(pos==9||pos==8)
                marginOverrider.overrideMarginTop(itemView,5,0)

        }



    }
}

