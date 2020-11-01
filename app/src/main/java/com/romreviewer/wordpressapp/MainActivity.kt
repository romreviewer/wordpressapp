package com.romreviewer.wordpressapp

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.romreviewer.wordpressapp.ui.dashboard.DashboardFragment
import com.romreviewer.wordpressapp.ui.home.HomeFragment
import com.romreviewer.wordpressapp.ui.notifications.NotificationsFragment

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationSetup()
    }
    private fun bottomNavigationSetup()
    {
        bottomNavigationView=findViewById(R.id.nav_view)
        viewPager=findViewById(R.id.view_pager)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            item: MenuItem ->
            when (item.itemId) {
                R.id.navigation_home -> viewPager.currentItem = 0
                R.id.navigation_dashboard -> viewPager.currentItem = 1
                R.id.navigation_notifications -> viewPager.currentItem = 2
            }
            return@setOnNavigationItemSelectedListener false
        }
        viewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when(position)
                {
                    0->bottomNavigationView.menu.getItem(0).isChecked = true
                    1->bottomNavigationView.menu.getItem(1).isChecked = true
                    2->bottomNavigationView.menu.getItem(2).isChecked = true
                }
            }
        })
        setUpViewPager()
    }
    private fun setUpViewPager()
    {
        val adapter=ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment())
        adapter.addFragment(DashboardFragment())
        adapter.addFragment(NotificationsFragment())
        viewPager.adapter=adapter
    }
}