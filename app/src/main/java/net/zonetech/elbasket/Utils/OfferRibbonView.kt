package net.zonetech.elbasket.Utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import net.zonetech.elbasket.R

class OfferRibbonView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var paint:Paint
    var marginOverrider=MarginOverrider(context)
    init {

        paint=Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color=ContextCompat.getColor(context, R.color.red)





    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawRibbon(canvas!!,layoutDirection== View.LAYOUT_DIRECTION_RTL)


    }


    private fun drawRibbon(
        canvas: Canvas,
        inverted:Boolean
    ) {


        val path = Path()
        path.fillType = Path.FillType.EVEN_ODD
        if(inverted){
            path.moveTo(marginOverrider.getPX(50).toFloat(), marginOverrider.getPX(0).toFloat())
            path.lineTo(marginOverrider.getPX(0).toFloat(), marginOverrider.getPX(0).toFloat())
            path.lineTo(marginOverrider.getPX(10).toFloat(), marginOverrider.getPX(5).toFloat())
            path.lineTo(marginOverrider.getPX(0).toFloat(), marginOverrider.getPX(10).toFloat())
            path.lineTo(marginOverrider.getPX(50).toFloat(), marginOverrider.getPX(10).toFloat())
            path.close()
        }
        else if(!inverted){
            path.moveTo(marginOverrider.getPX(0).toFloat(), marginOverrider.getPX(0).toFloat())
            path.lineTo(marginOverrider.getPX(50).toFloat(), marginOverrider.getPX(0).toFloat())
            path.lineTo(marginOverrider.getPX(40).toFloat(), marginOverrider.getPX(5).toFloat())
            path.lineTo(marginOverrider.getPX(50).toFloat(), marginOverrider.getPX(10).toFloat())
            path.lineTo(marginOverrider.getPX(0).toFloat(), marginOverrider.getPX(10).toFloat())
            path.close()
        }


        canvas.drawPath(path, paint)
    }

}





