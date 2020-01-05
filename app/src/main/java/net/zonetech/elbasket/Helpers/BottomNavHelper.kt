package net.zonetech.elbasket.Helpers

import android.content.Context
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentContainer
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.tab_item.view.*
import net.zonetech.elbasket.Adapters.PagerStateAdapter
import net.zonetech.elbasket.Fragments.*
import net.zonetech.elbasket.R
import net.zonetech.elbasket.Utils.CommonMethods
import java.util.*

class BottomNavHelper(
    var mainContainer: View?,
    var pagerContainer: ViewPager,
    var bottomNav: TabLayout,
    var fm: FragmentManager,
    var Index: Int,
    var context: Context
) {
    var pageHistory = Stack<Int>()
    var commonMethods: CommonMethods
    var fonts:Fonts
    init {
        commonMethods= CommonMethods(context)
        fonts=Fonts(context)
    }
    fun setupViewPager() {
        fonts.Fonts()
        if(fonts.isArabic){

        }
        addTabsInAdapter()
        bottomNav.setupWithViewPager(pagerContainer)
        initBottomNav()
//        if (Index != -1) {
//            var tab = bottomNav.getTabAt(Index)
//            colorView(tab!!.view,true)
//            tab!!.select()
//            pageHistory.push(Index)
//        }
//
//        else{
         var tab=bottomNav.getTabAt(bottomNav.selectedTabPosition)
         colorView(tab!!.view,true)
         pageHistory.push(Index)

//        }


        bottomNav.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                if (mainContainer != null) {
                    mainContainer!!.visibility = View.GONE
                    pagerContainer.visibility = View.VISIBLE
                    pagerContainer.setCurrentItem(p0!!.position)
                }

            }

        })
        pagerContainer.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                selectTab(p0)
                pageHistory.push(p0)
            }

        })


    }

    private fun addTabsInAdapter() {
        var adapter = PagerStateAdapter(fm)
        adapter.addFragment(HomeFragment())
        adapter.addFragment(OffersFragment())
        adapter.addFragment(SearchFragment())
        adapter.addFragment(CartFragment())
        adapter.addFragment(AccountFragment())
        pagerContainer.adapter = adapter
    }

    private fun selectTab(p0: Int) {
        when (p0) {
            0 -> {
                var tab0= bottomNav.getTabAt(p0)!!.view
                colorView(tab0,true)
                var tab1=bottomNav.getTabAt(1)!!.view
                colorView(tab1,false)
                var tab2= bottomNav.getTabAt(2)!!.view
                colorView(tab2,false)
                var tab3= bottomNav.getTabAt(3)!!.view
                colorView(tab3,false)
                var tab4= bottomNav.getTabAt(4)!!.view
                colorView(tab4,false)
            }

            1 -> {
                var tab0=bottomNav.getTabAt(0)!!.view
                colorView(tab0,false)
                var tab1= bottomNav.getTabAt(p0)!!.view
                colorView(tab1,true)
                var tab2= bottomNav.getTabAt(2)!!.view
                colorView(tab2,false)
                var tab3= bottomNav.getTabAt(3)!!.view
                colorView(tab3,false)
                var tab4= bottomNav.getTabAt(4)!!.view
                colorView(tab4,false)
            }

            2 -> {
                var tab0=bottomNav.getTabAt(0)!!.view
                colorView(tab0,false)
                var tab1= bottomNav.getTabAt(1)!!.view
                colorView(tab1,false)
                var tab2= bottomNav.getTabAt(p0)!!.view
                colorView(tab2,true)
                var tab3= bottomNav.getTabAt(3)!!.view
                colorView(tab3,false)
                var tab4= bottomNav.getTabAt(4)!!.view
                colorView(tab4,false)
            }

            3 -> {
                var tab0=bottomNav.getTabAt(0)!!.view
                colorView(tab0,false)
                var tab1= bottomNav.getTabAt(1)!!.view
                colorView(tab1,false)
                var tab2= bottomNav.getTabAt(2)!!.view
                colorView(tab2,false)
                var tab3= bottomNav.getTabAt(p0)!!.view
                colorView(tab3,true)
                var tab4= bottomNav.getTabAt(4)!!.view
                colorView(tab4,false)
            }

            4 ->{
                var tab0=bottomNav.getTabAt(0)!!.view
                colorView(tab0,false)
                var tab1= bottomNav.getTabAt(1)!!.view
                colorView(tab1,false)
                var tab2= bottomNav.getTabAt(2)!!.view
                colorView(tab2,false)
                var tab3= bottomNav.getTabAt(3)!!.view
                colorView(tab3,false)
                var tab4= bottomNav.getTabAt(p0)!!.view
                colorView(tab4,true)
            }
            else->{ }
        }
    }

    private fun initBottomNav() {
        var tabViewHelper = TabViewHelper(context)
        tabViewHelper.initTabsArrays()

        for (i in 0 until 5) {
            val tab = bottomNav.getTabAt(i)
            tab!!.customView = tabViewHelper.getTabView(i)
        }
    }


    private fun colorView(customTabView:View,colored:Boolean) {

        if(colored){
            customTabView.tabIcon.setTextColor(ContextCompat.getColor(context, R.color.white))
            customTabView.tabTitle.setTextColor(ContextCompat.getColor(context, R.color.white))
        }
        else{
            customTabView.tabIcon.setTextColor(ContextCompat.getColor(context, R.color.grey))
            customTabView.tabTitle.setTextColor(ContextCompat.getColor(context, R.color.grey))
        }

    }
}