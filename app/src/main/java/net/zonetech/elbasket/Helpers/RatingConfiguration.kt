package net.zonetech.elbasket.Helpers

import android.content.Context
import android.content.res.Resources
import android.support.v4.content.ContextCompat
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import net.zonetech.elbasket.R


class RatingConfiguration() {
    companion object{
        fun setupText( context: Context,rating:Float) :Spannable{
            var stringBuilder=StringBuilder()

            stringBuilder.append(context.getString(R.string.starIcon))
            stringBuilder.append(context.getString(R.string.starIcon))
            stringBuilder.append(context.getString(R.string.starIcon))
            stringBuilder.append(context.getString(R.string.starIcon))
            stringBuilder.append(context.getString(R.string.starIcon))

            var spannable=SpannableString(stringBuilder)

            val ratingPure = rating
            val ratingRounded = Math.round(ratingPure)
            val notRatingRounded = Math.abs(ratingRounded - 5)

            var fonts=Fonts(context)
            fonts.Fonts()

            if(fonts.isArabic){

                spannable.setSpan(
                    ForegroundColorSpan(
                        ContextCompat.getColor(
                            context,
                            R.color.lightGrey
                        )
                    ), 0, notRatingRounded, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                spannable.setSpan(
                    ForegroundColorSpan(
                        ContextCompat.getColor(
                            context,
                            R.color.colorAccent
                        )
                    ), notRatingRounded, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            else{
                spannable.setSpan(
                    ForegroundColorSpan(
                        ContextCompat.getColor(
                            context,
                            R.color.colorAccent
                        )
                    ), 0, ratingRounded, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                spannable.setSpan(
                    ForegroundColorSpan(
                        ContextCompat.getColor(
                            context,
                            R.color.lightGrey
                        )
                    ), ratingRounded, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }


      return spannable }
    }


}