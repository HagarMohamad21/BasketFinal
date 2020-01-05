package net.zonetech.elbasket.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.CommonMethods
import net.zonetech.elbasket.Utils.MarginOverrider

class SponsorAdapter(var context: Context) :RecyclerView.Adapter<SponsorAdapter.SponsorViewHolder>(){
    var commonMethods=CommonMethods(context)
    var marginOverrider= MarginOverrider(context)
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SponsorViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.sponsor_list_item,p0,false)
        return SponsorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(p0: SponsorViewHolder, p1: Int) {
     p0.bind(p1)
    }

    inner class SponsorViewHolder( itemView:View) :RecyclerView.ViewHolder(itemView) {

        fun bind(pos: Int) {
            commonMethods.setupFonts(itemView)
            if(pos==0){
                marginOverrider.overrideMarginSides(itemView,true)
            }

            else if(pos==4){
                marginOverrider.overrideMarginSides(itemView,false)

            }
        }

    }

}

