package net.zonetech.elbasket.Utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.zonetech.elbasket.Activities.SchoolActivity
import net.zonetech.elbasket.Activities.SplashActivity


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

fun uselessFunction(){}

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

