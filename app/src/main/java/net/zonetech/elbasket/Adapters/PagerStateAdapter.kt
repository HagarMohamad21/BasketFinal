package net.zonetech.elbasket.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class PagerStateAdapter(fm:FragmentManager) : FragmentStatePagerAdapter(fm) {
    private val mFragmentList = ArrayList<Fragment>()

    override fun getItem(p0: Int): Fragment {
       return mFragmentList[p0]
    }

    override fun getCount(): Int {
      return mFragmentList.size
    }

    fun addFragment(fragment: Fragment) {
        mFragmentList.add(fragment)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 ->{
                return "HOME"
            }
            1->{
                return "OFFERS"
            }
            2->{
                return "SEARCH"
            }
            3->{
                return "CART"
            }

            else->{
                return "ACCOUNT"
            }
        }

    }
}