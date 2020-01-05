
package net.zonetech.elbasket.Adapters

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.offer_detail_list_item.view.*
import net.zonetech.elbasket.Helpers.RatingConfiguration
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.CommonMethods
import net.zonetech.elbasket.Utils.MarginOverrider

class RatingAdapter(var context: Context,var configuration:Int): RecyclerView.Adapter<RatingAdapter.RatingHolder>() {
    var commonMethods= CommonMethods(context)
    var marginOverrider= MarginOverrider(context)


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RatingHolder {
        var view: View?
        view = if(configuration==LinearLayoutManager.HORIZONTAL){
            LayoutInflater.from(context).inflate(R.layout.rating_list_item_horizontal,p0,false)
        } else{
            LayoutInflater.from(context).inflate(R.layout.rating_list_item,p0,false)

        }
        return RatingHolder(view)
    }

    override fun getItemCount(): Int {
        return 10   }

    override fun onBindViewHolder(p0: RatingHolder, p1: Int) {
        p0.bind(p1)
    }


    inner class RatingHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pos: Int){
            commonMethods.setupFonts(itemView)
            var spannable= RatingConfiguration.setupText(context,3f)
            itemView.ratingTxt.setText(spannable)
            overrideMargins(pos)
        }

        private fun overrideMargins(
            pos: Int
        ) {
            if(configuration==LinearLayoutManager.HORIZONTAL){
                if(pos==0){
                    marginOverrider.overrideMarginSides(itemView,true)
                }

                else if(pos==9){
                    marginOverrider.overrideMarginSides(itemView,false)

                }
            }
            else{
                if(pos==0){
                    marginOverrider.overrideMarginTop(itemView,0,5)

                }
                else if(pos==9)
                    marginOverrider.overrideMarginTop(itemView,5,10)
            }


        }
    }

}
