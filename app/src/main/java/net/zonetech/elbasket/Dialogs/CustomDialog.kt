package net.zonetech.elbasket.Dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Window
import com.example.basketrecyclerviewbased.Interfaces.OnReplaceLayoutRequest
import kotlinx.android.synthetic.main.custom_dialog.*
import net.zonetech.elbasket.Adapters.RatingDialogAdapter
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.Common
import net.zonetech.elbasket.Utils.CommonMethods
import net.zonetech.elbasket.Utils.ItemDecoration
import net.zonetech.elbasket.Utils.toggleVisiblity

class CustomDialog(context: Context,message:String?,var LayoutType:Int) : Dialog(context),OnReplaceLayoutRequest {
    override fun replaceLayout(fragmentNum: Int, layoutType: Int) {

    }
    lateinit var commonMethods:CommonMethods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setListeners()
    }

    private fun initViews() {
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        if(LayoutType==Common.RATING_DIALOG){
            setContentView(R.layout.rating_dialog)
        }
        else{
            setContentView(R.layout.custom_dialog)
        }

        commonMethods= CommonMethods(context)
        commonMethods.setupFonts(findViewById(android.R.id.content))
        if(LayoutType==Common.DIALOG_IMAGE){
            cancelDialogView.toggleVisiblity(false)
            dialogList.toggleVisiblity(true)
            populateImage()
            dialogNameTxt!!.text=context.getString(R.string.choose_image)
        }
        else if(LayoutType==Common.RATING_DIALOG){
            populateRating()
        }
//        else{
//            cancelDialogView.toggleVisiblity(true)
//            dialogList.toggleVisiblity(false)
//        }
    }

    private fun populateRating() {
      dialogList.layoutManager=LinearLayoutManager(context)
     dialogList.addItemDecoration(ItemDecoration(context,""))
        var adapter=RatingDialogAdapter(context,commonMethods.ratingList())
        dialogList.adapter=adapter
    }

    private fun populateImage() {
        CommonMethods(context).populateMainList(dialogList, Common.DIALOG_IMAGE, this, null)
    }

    private fun setListeners() {
        closeBtn.setOnClickListener {
            dismiss()
        }
        if(LayoutType==Common.RATING_DIALOG){

        }
        else{
            yesBtn.setOnClickListener {
                dismiss()
            }
            noBtn.setOnClickListener {
                dismiss()
            }

        }

    }


}