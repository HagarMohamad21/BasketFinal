package net.zonetech.elbasket.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.rating_dialog_list_item.view.*
import net.zonetech.elbasket.Helpers.RatingConfiguration
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.CommonMethods

class RatingDialogAdapter(
    var context: Context,
    var ratingList: ArrayList<String>
) : RecyclerView.Adapter<RatingDialogAdapter.RatingDialogHolder>() {

    var commonMethods=CommonMethods(context)
    var checkedPos=-1
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RatingDialogHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.rating_dialog_list_item,p0,false)
        return RatingDialogHolder(view)
    }

    override fun getItemCount(): Int {
          return ratingList.size }

    override fun onBindViewHolder(p0: RatingDialogHolder, p1: Int) {
       p0.bind(p1)
    }

    private val TAG = "RatingDialogAdapter"
    inner class RatingDialogHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        
        fun bind(pos:Int) {
            Log.d(TAG, "bind: ::::::::;$pos")
            commonMethods.setupFonts(itemView)
            itemView.ratingTxt.text=ratingList[pos]
            itemView.ratingValue.text=RatingConfiguration.setupText(context,(ratingList.size-pos).toFloat())
             if(checkedPos==-1){
                 Log.d(TAG, "bind: first pos =-1")
                 itemView.root.isSelected=false  
             }
            

            else{
                 itemView.root.isSelected = checkedPos == adapterPosition
             }


            itemView.setOnClickListener {
                itemView.root.isSelected=true
                if(checkedPos!=adapterPosition){
                    notifyItemChanged(checkedPos)
                    checkedPos=adapterPosition
                }
            }
        }
    }
}