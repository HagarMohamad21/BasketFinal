package net.zonetech.elbasket.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.zonetech.elbasket.Helpers.RatingConfiguration
import net.zonetech.elbasket.R
import android.support.constraint.ConstraintLayout
import android.widget.ImageView
import com.example.basketrecyclerviewbased.Interfaces.OnReplaceLayoutRequest
import kotlinx.android.synthetic.main.offer_detail_list_item.view.*
import net.zonetech.elbasket.Activities.OfferItemActivity
import net.zonetech.elbasket.Models.Offer
import net.zonetech.elbasket.Utils.*


class OfferDetailsAdapter(var context: Context,var offers:ArrayList<Offer>?) : RecyclerView.Adapter<OfferDetailsAdapter.OfferDetailHolder>() {

    var onReplaceLayoutRequest:OnReplaceLayoutRequest?=null
    set(value) {
        field=value
    }

var commonMethods = CommonMethods(context)
var marginOverrider= MarginOverrider(context)

var hasRibbon="FALSE"
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): OfferDetailHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.offer_detail_list_item,p0,false)
        return OfferDetailHolder(view)
    }

    override fun getItemCount()=4

    override fun onBindViewHolder(p0: OfferDetailHolder, p1: Int) {
     p0.bind(p1)
    }

    inner class OfferDetailHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var isFav:Boolean=false
        init {

           commonMethods.setupFonts(itemView)
        }

        fun bind(pos:Int){

            when(pos){
               0, 2->{
                    itemView.discountTxt.toggleVisiblity(true)
                    itemView.offerRibbonView.toggleVisiblity(true)
                }
            }
            if (offers != null) {
                itemView.titleTxt.text=offers!![pos].offerName
                itemView.offerImage.setImageResource(offers!![pos].offerImage)
            }

            var spannable=RatingConfiguration.setupText(context,3f)
            itemView.ratingTxt.text = spannable
            overrideMargins(pos)
            setListeners(pos)
        }

        private fun setListeners(pos: Int) {
            itemView.root.setOnClickListener {
               hasRibbon= when(pos){
                    0, 2,4->{
                      "TRUE"
                    }
                   else -> "FALSE"
               }
               context.openOffer(OfferItemActivity(),hasRibbon,offers!![pos])
            }
            itemView.favouriteBtn.setOnClickListener {
                if(!isFav){
                    itemView.favouriteBtn.text = context.getString(R.string.filledHeart)
                    isFav=true
                }
                else{
                    isFav=false
                    itemView.favouriteBtn.text = context.getString(R.string.heartIcon)
                }

            }
        }

        private fun overrideMargins(
            pos: Int
        ) {
            if(pos==0){
                marginOverrider.overrideMarginTop(itemView,0,5)

            }
            else if(pos==4)
                marginOverrider.overrideMarginTop(itemView,5,10)

        }
    }
}