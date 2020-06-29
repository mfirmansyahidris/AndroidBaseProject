package com.fi.androidbaseproject.screen

import android.view.Menu
import androidx.fragment.app.Fragment
import com.fi.androidbaseproject.R
import com.fi.androidbaseproject.base.BaseActivity
import com.fi.androidbaseproject.screen.about.AboutFragment
import com.fi.androidbaseproject.screen.api.ApiFragment
import com.fi.androidbaseproject.screen.room.RoomFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private var menuItem: Menu? = null

    override fun setLayoutResource(): Int = R.layout.activity_main

    override fun setToolbarResource(): Int = 0

    override fun setToolbarActionButton(): Boolean = false

    override fun initUI() {
        setMenuNavigation()
    }

    private fun setMenuNavigation() {
        bn_main.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navMenu_api -> openFragment(ApiFragment())
                R.id.navMenu_room -> openFragment(RoomFragment())
                R.id.navMenu_about -> openFragment(AboutFragment())
            }
            true
        }
        bn_main.selectedItemId = R.id.navMenu_api
        val badge = bn_main.getOrCreateBadge(R.id.navMenu_about)
        badge.isVisible = true
        badge.number = 30
    }

    private fun openFragment(fragment: Fragment) {
        //supportActionBar?.subtitle = title
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.cl_container, fragment)
        ft.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        menuItem = menu

        return true
    }
}
