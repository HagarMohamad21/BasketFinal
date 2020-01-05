package net.zonetech.elbasket.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.zonetech.elbasket.Models.Category
import net.zonetech.elbasket.R
import kotlinx.android.synthetic.main.category_list_item.view.*
import net.zonetech.elbasket.Activities.OfferDetailsActivity
import net.zonetech.elbasket.Utils.CommonMethods
import net.zonetech.elbasket.Utils.MarginOverrider
import net.zonetech.elbasket.Utils.open


class CategoryAdapter(var categories:ArrayList<Category>,var c:Context) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    var commonMethods= CommonMethods(c)
    var marginOverrider= MarginOverrider(c)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CategoryViewHolder {
        val view=LayoutInflater.from(c).inflate(R.layout.category_list_item,p0,false
        )
    return CategoryViewHolder(view)
    }


    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(p0: CategoryViewHolder, p1: Int) {
    p0.bind(categories[p1],p1)
    }


    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val TAG = "CategoryAdapter"
        fun bind(category: Category, pos: Int){
            commonMethods.setupFonts(itemView)
            itemView.categoryName.text=category.name
            overrideMargins(pos)
            itemView.setOnClickListener{
                c.open(OfferDetailsActivity(), category.name)
            }
        }

        private fun overrideMargins(
            pos: Int
        ) {
            when(pos){
                0,3->{
                    marginOverrider.overrideMarginSidesForGridLayout(itemView,true)
                }
                2,5->{
                    marginOverrider.overrideMarginSidesForGridLayout(itemView,false)
                }
            }

            when (pos){
                0,1,2->{
                    marginOverrider.overrideMarginTop(itemView,0,5)
                }
                else->{
                    marginOverrider.overrideMarginTop(itemView,5,10)
                }
            }


        }
    }


}