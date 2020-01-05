package net.zonetech.elbasket.Adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.basketrecyclerviewbased.Interfaces.OnReplaceLayoutRequest
import kotlinx.android.synthetic.main.account_menu_list_item.view.*
import net.zonetech.elbasket.Activities.SplashActivity
import net.zonetech.elbasket.Helpers.Fonts
import net.zonetech.elbasket.Interfaces.AccountMenuListener
import net.zonetech.elbasket.Models.Menu
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.*


class MenuAdapter(
    val context: Context, val list:ArrayList<Menu>,
    var layoutType: Int
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    var isArabic=false
    var fonts:Fonts
    init {
       fonts= Fonts(context)
        fonts.Fonts()
        isArabic=fonts.isArabic

    }
    var accountMenuListener: AccountMenuListener?=null
        set(value) {
          field=value
        }
    var onReplaceLayoutRequest: OnReplaceLayoutRequest?=null
    set(value) {
        field=value
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MenuViewHolder {
        return MenuViewHolder(LayoutInflater.from(context).inflate(R.layout.account_menu_list_item,p0,false))
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(menuView: MenuViewHolder, pos: Int) {
        menuView.bind(list.get(pos),pos)
    }


    inner class MenuViewHolder(  itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(menu: Menu, pos: Int){

            fonts.setTypeFce(itemView)
            if(layoutType==Common.LAYOUT_DRAWER_MENU){
                itemView.iconTxt.changeColor(R.color.white,context)
                itemView.menuTitleTxt.changeColor(R.color.white,context)
            }

            itemView.iconTxt.text = menu.itemIcon
            itemView.menuTitleTxt.text = menu.itemName

            if (layoutType==Common.LAYOUT_ACCOUNT_MENU&&pos==Common.ITEM_LANGUAGE){
                itemView.languageSwitch.toggleVisiblity(true)
                itemView.menuTitleTxt.text = context.getString(R.string.switch_to_arabic)
            }
            setListeners(pos,layoutType,context,isArabic)
        }

        private fun setListeners(
            pos: Int,
            layoutType: Int,
            context: Context,
            isArabic: Boolean
        ) {
            if(layoutType==Common.LAYOUT_DRAWER_MENU) {
                itemView.setOnClickListener {
                    onReplaceLayoutRequest!!.replaceLayout(pos,layoutType)
                }
            }
            else{
                itemView.languageSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        if (!isArabic) {
                            context.changeLanguage("ar")
                            context.openWithoutBackStack()

                        } else if (isArabic) {
                            context.changeLanguage("en")
                            context.openWithoutBackStack()

                        }


                    }
                }
//                itemView.setOnClickListener {
//                    onReplaceLayoutRequest!!.replaceLayout(pos,layoutType)
//                }
            }
        }




}
    }
