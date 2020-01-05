package net.zonetech.elbasket.Helpers

import android.content.Context
import android.content.res.Resources
import android.graphics.Typeface
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.zonetech.elbasket.Utils.Common

class Fonts constructor(private val mContext: Context){



    lateinit var mediumFont:Typeface
    lateinit var lightFont:Typeface
    lateinit var iconsFont:Typeface


    var isArabic: Boolean = false



    fun Fonts(){

        val language = Resources.getSystem().configuration.locale
        val langPref = mContext.getSharedPreferences(mContext.packageName, 0)
        val lang = langPref.getString(Common.SELECTED_LANGUAGE, language.language)

        if (lang == "ar") {
            isArabic = true
            lightFont  = Typeface.createFromAsset(mContext.assets, "fonts/ge ss text light.otf")
            mediumFont  = Typeface.createFromAsset(mContext.assets, "fonts/ge ss text bold.otf")
        } else {
            isArabic = false
            mediumFont = Typeface.createFromAsset(mContext.assets, "fonts/englishlight.ttf")
            lightFont = Typeface.createFromAsset(mContext.assets, "fonts/englishbold.ttf")
        }

        iconsFont = Typeface.createFromAsset(mContext.assets, "fonts/elBasket.ttf")
    }


    fun setTypeFce(view: View) {
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val child = view.getChildAt(i)
                setTypeFce(child)
            }
        } else if (view is TextView) {
            if (view.tag != null) {

                val tag = view.tag.toString()
                if (tag == "icon") {
                    view.typeface = iconsFont

                } else if (tag == "regular") {
                    view.typeface = lightFont

                } else if (tag == "bold") {
                    view.typeface = mediumFont

                }

            }
        }

    }

}