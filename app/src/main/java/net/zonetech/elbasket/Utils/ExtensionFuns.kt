package net.zonetech.elbasket.Utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.zonetech.elbasket.Activities.OfferItemActivity
import net.zonetech.elbasket.Activities.SchoolActivity
import net.zonetech.elbasket.Activities.SplashActivity
import net.zonetech.elbasket.Models.Offer
import net.zonetech.elbasket.R


fun Context.open(activity: Activity, extra: String?){

        var intent=Intent(this.applicationContext,activity::class.java)
    if (extra != null) {
        intent.putExtra("Extras",extra)
    }
        this.startActivity(intent)
    }

fun View.toggleVisiblity(show: Boolean){
    if(show)
        this.visibility=View.VISIBLE
     else
        this.visibility=View.GONE

 }

fun Context.openWithoutBackStack(){
    var intent= Intent(this, SplashActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
    this.startActivity(intent)
}

fun Context.changeLanguage(language:String){
    val languagePref = this.getSharedPreferences(this.getPackageName(), Context.MODE_PRIVATE)
    val editor = languagePref?.edit()
    editor?.putString(Common.SELECTED_LANGUAGE, language)
    editor?.apply()
}

fun TextView.changeColor(colorId:Int,context: Context){
    this.setTextColor(context.resources.getColor(colorId))
}

fun getOffers(): ArrayList<Offer> {
    var offer1= Offer(offerImage = R.mipmap.pasta,offerName = "Pasta")
    var offer2=Offer(offerImage = R.mipmap.rice,offerName = "Rice")
    var offer3=Offer(offerImage = R.mipmap.indianrice,offerName = "Indian Rice")
    var offer4=Offer(offerImage = R.mipmap.biscuits,offerName = "Biscuits")
    var offer5=Offer(offerImage = R.mipmap.mamual,offerName = "Maamual")
    var offer6=Offer(offerImage = R.mipmap.peanutbutter,offerName = "Peanut butter")
    var offer7=Offer(offerImage = R.mipmap.pretzels,offerName = "Pretzels")
    var offer8=Offer(offerImage = R.mipmap.sweetcorn,offerName = "Sweet corn")
    val array=ArrayList<Offer>()
    array.add(offer1)
    array.add(offer2)
    array.add(offer3)
    array.add(offer4)
    array.add(offer5)
    array.add(offer6)
    array.add(offer7)
    array.add(offer8)
    return array

}

fun View.overrideTopMargin(value:Int){
val params=getParams()
    params.topMargin=value
    this.layoutParams=params
}
fun View.overrideLeftMargin(value: Int){
        val params=getParams()
       params.leftMargin = value
        this.setLayoutParams(params)
}

fun View.overrideRightMargin(value: Int){
    val params=getParams()
    params.rightMargin = value
    this.setLayoutParams(params)
}

fun View.overrideBottomMargin(value: Int){
    val params=getParams()
    params.bottomMargin=value
    this.layoutParams=params
}

fun View.getParams():ViewGroup.MarginLayoutParams{
    val params = this.getLayoutParams() as ViewGroup.MarginLayoutParams
    return params
}

fun View.overrideStartMargin(value: Int){
    val params=getParams()
    params.marginStart = value
    this.setLayoutParams(params)
}
fun View.overrideEndMargin(value: Int){
    val params=getParams()
    params.marginEnd = value
    this.setLayoutParams(params)
}

fun Context.openOffer(activity: Activity, extra: String, offer: Offer) {
    var intent=Intent(this.applicationContext,activity::class.java)
        intent.putExtra("Extras",extra)
    intent.putExtra("Offer",offer)
    this.startActivity(intent)
}

fun getCategories():ArrayList<Offer>{
    var offer1= Offer(offerImage = R.mipmap.clothes,offerName = "Clothes")
    var offer2=Offer(offerImage = R.mipmap.kids,offerName = "Kids")
    var offer3=Offer(offerImage = R.mipmap.school,offerName = "School supplies")
    var offer4=Offer(offerImage = R.mipmap.electronics,offerName = "Electronics")
    var offer5=Offer(offerImage = R.mipmap.supermarket,offerName = "Super market")
    var offer6=Offer(offerImage = R.mipmap.phones,offerName = "Smart phones")

    val array=ArrayList<Offer>()
    array.add(offer1)
    array.add(offer2)
    array.add(offer3)
    array.add(offer4)
    array.add(offer5)
    array.add(offer6)
    return array
}

fun getClothes(): ArrayList<Offer> {
    Log.d("getClothes","==============================================")
    val array=ArrayList<Offer>()
    var offer1= Offer(offerImage = R.mipmap.cloths1,offerName = "Sweater")
    var offer2=Offer(offerImage = R.mipmap.cloths2,offerName = "T-Shirt")
    var offer3=Offer(offerImage = R.mipmap.cloths3,offerName = "Gloves")
    var offer4=Offer(offerImage = R.mipmap.boots,offerName = "Boots")
    array.add(offer1)
    array.add(offer2)
    array.add(offer3)
    array.add(offer4)

    return array
}

fun getKids(): ArrayList<Offer> {
    val array=ArrayList<Offer>()
    var offer1= Offer(offerImage = R.mipmap.kids1,offerName = "Sweater")
    var offer2=Offer(offerImage = R.mipmap.kids2,offerName = "T-Shirt")
    var offer3=Offer(offerImage = R.mipmap.kids3,offerName = "Short and T-shirt")
    var offer4=Offer(offerImage = R.mipmap.kids4,offerName = "Shoes")
    array.add(offer1)
    array.add(offer2)
    array.add(offer3)
    array.add(offer4)

    return array
}

fun getElectronics(): ArrayList<Offer> {
    val array=ArrayList<Offer>()
    var offer1= Offer(offerImage = R.mipmap.washing_machine,offerName = "Washing machine")
    var offer2=Offer(offerImage = R.mipmap.toaster,offerName = "Toaster")
    var offer3=Offer(offerImage = R.mipmap.coffee_machine,offerName = "Coffee machine")
    var offer4=Offer(offerImage = R.mipmap.blender,offerName = "Blender")
    array.add(offer1)
    array.add(offer2)
    array.add(offer3)
    array.add(offer4)

    return array
}

fun getSchool(): ArrayList<Offer> {
    val array=ArrayList<Offer>()
    var offer1= Offer(offerImage = R.mipmap.notebook,offerName = "Note book")
    var offer2=Offer(offerImage = R.mipmap.pens,offerName = "Pens")
    var offer3=Offer(offerImage = R.mipmap.bag,offerName = "Bag")
    var offer4=Offer(offerImage = R.mipmap.pencase,offerName = "pens case")
    array.add(offer1)
    array.add(offer2)
    array.add(offer3)
    array.add(offer4)

    return array

}

fun getPhones(): ArrayList<Offer> {
    val array=ArrayList<Offer>()
    var offer1= Offer(offerImage = R.mipmap.galaxyphone,offerName = "Iphone")
    var offer2=Offer(offerImage = R.mipmap.phone1,offerName = "Galaxy phone")
    var offer3=Offer(offerImage = R.mipmap.phone2,offerName = "Iphone")
    var offer4=Offer(offerImage = R.mipmap.phone3,offerName = "Galaxy phone")
    array.add(offer1)
    array.add(offer2)
    array.add(offer3)
    array.add(offer4)

    return array

}
