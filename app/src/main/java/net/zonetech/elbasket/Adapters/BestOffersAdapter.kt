package net.zonetech.elbasket.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.offer_list_item.view.*
import net.zonetech.elbasket.Activities.OfferItemActivity
import net.zonetech.elbasket.Models.Offer
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.CommonMethods
import net.zonetech.elbasket.Utils.MarginOverrider
import net.zonetech.elbasket.Utils.open

class BestOffersAdapter(var context: Context, var offersList: ArrayList<Offer>?) : RecyclerView.Adapter<BestOffersAdapter.OfferViewHolder>() {

    var commonMethods = CommonMethods(context)
    var marginOverrider=MarginOverrider(context)
    var hasRibbon="TRUE"
    override fun getItemCount(): Int {
        return 10;
    }

    override fun onBindViewHolder(p0: OfferViewHolder, p1: Int) {
      p0.bind(p1)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): OfferViewHolder {
     val view=LayoutInflater.from(context).inflate(R.layout.best_offer_list_item,p0,false)
        return OfferViewHolder(view)
    }


    override fun onViewRecycled(holder: OfferViewHolder) {
        super.onViewRecycled(holder)
        marginOverrider.overrideMarginSides(holder.itemView)
    }
    inner class OfferViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
       fun bind(pos:Int){
           commonMethods.setupFonts(itemView)
           if(pos==0){
               marginOverrider.overrideMarginSides(itemView,true)
           }

           else if(pos==9){
               marginOverrider.overrideMarginSides(itemView,false)

           }
           itemView.setOnClickListener {
               context.open(OfferItemActivity(),hasRibbon)
           } }

    }


}