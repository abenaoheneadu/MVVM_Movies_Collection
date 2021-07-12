package com.dynnamicdevz.mymoviescollectionapp.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dynnamicdevz.mymoviescollectionapp.view.fragment.FavoritesFragment
import com.dynnamicdevz.mymoviescollectionapp.view.fragment.MainPageFragment

class HomeFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(
    fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> MainPageFragment()

            else ->FavoritesFragment()
        }
    }
}