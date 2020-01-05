package net.zonetech.elbasket.Adapters


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cart_list_item.view.*
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.CommonMethods
import net.zonetech.elbasket.Utils.MarginOverrider


class CartAdapter(var c:Context) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {


    var commonMethods = CommonMethods(c)
    var marginOverrider= MarginOverrider(c)


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CartViewHolder {
     var itemView=LayoutInflater.from(c).inflate(R.layout.cart_list_item,p0,false)
        return CartViewHolder (itemView)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(p0: CartViewHolder, p1: Int) {
      p0.bind(p1)
    }


    inner class CartViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView) {
        var quantity=0

        fun bind(pos: Int){
            commonMethods.setupFonts(itemView)
            setListeners()
            overrideMargins(commonMethods,pos)

        }


        private fun setListeners(){

            itemView.addBtn.setOnClickListener {

                quantity++
                itemView.quantityTxt.setText(quantity.toString())
            }
            itemView.removeBtn.setOnClickListener {
                if(quantity!=0)
                    quantity--

                itemView.quantityTxt.setText(quantity.toString())
            }



        }


        private fun overrideMargins(
            commonMethods: CommonMethods,
            pos: Int

        ) {
            if(pos==0){
                marginOverrider.overrideMarginTop(itemView,0,5)

            }
            else if(pos==9)
                marginOverrider.overrideMarginTop(itemView,5,0)

        }
    }
}