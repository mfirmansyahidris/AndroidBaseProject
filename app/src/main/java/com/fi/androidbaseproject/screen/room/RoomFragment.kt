package com.fi.androidbaseproject.screen.room

import com.fi.androidbaseproject.R
import com.fi.androidbaseproject.base.BaseFragment
import kotlinx.android.synthetic.main.toolbar_main.*

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/06/2020, 01:56 PM
 ****************************************
 */

class RoomFragment : BaseFragment(){
    override fun setLayoutResource(): Int = R.layout.fragment_room

    override fun initUI() {
        activity.toolbar.title = getString(R.string.menu_room)
    }

}