package net.zonetech.elbasket.Adapters

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.image_chooser_item.view.*
import net.zonetech.elbasket.Helpers.Fonts
import net.zonetech.elbasket.Interfaces.OnImageChooserSelected
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.Common
import net.zonetech.elbasket.Utils.CommonMethods

class ImageChooserAdapter(var context: Context) : RecyclerView.Adapter<ImageChooserAdapter.ImageChooserHolder>() {

    var onImageChooserSelected:OnImageChooserSelected?=null
    set(value) {field=value}
    private var images=ArrayList<String>()
    var fonts:Fonts
    init {
        fonts= Fonts(context)

        images.add(context.getString(R.string.gallery))
        images.add(context.getString(R.string.camera))
    }



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ImageChooserHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.image_chooser_item,null,false)
        return ImageChooserHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(p0: ImageChooserHolder, p1: Int) {
        p0.bind(images[p1],p1)
    }


    inner class ImageChooserHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        fun bind(itemName:String,pos:Int){
            fonts.Fonts()
            fonts.setTypeFce(itemView)
            //pos 0 open camera
            //pos 1 opens gallery
            itemView.dialogListItem.text=itemName
            itemView.setOnClickListener{
                //check permission
            }

        }
    }
}