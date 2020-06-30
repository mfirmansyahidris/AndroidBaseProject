package com.fi.androidbaseproject.screen.room

import android.util.Log
import com.fi.androidbaseproject.R
import com.fi.androidbaseproject.base.BaseFragment
import com.fi.androidbaseproject.models.Name
import com.fi.androidbaseproject.utils.Utils
import kotlinx.android.synthetic.main.fragment_room.*
import kotlinx.android.synthetic.main.toolbar_main.*

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/06/2020, 01:56 PM
 ****************************************
 */

class RoomFragment : BaseFragment(), RoomView.View {
    private val adapter = RoomAdapter()
    private lateinit var presenter: RoomPresenter

    override fun setLayoutResource(): Int = R.layout.fragment_room

    override fun initUI() {
        presenter = RoomPresenter(this)
        activity.toolbar.title = getString(R.string.menu_room)
        fab.setOnClickListener { presenter.saveData(db, Name(name = et.text.toString())) }

        rv.adapter = adapter
        presenter.getData(db)
    }

    override fun onSaveSuccess() {
        presenter.getData(db)
    }

    override fun onSaveError(message: String) {
        Log.e(Utils.tag, message)
    }

    override fun onGetDataSuccess(data: List<Name>) {
        adapter.data = data
    }

    override fun onGetDataError(message: String) {
        Log.e(Utils.tag, message)
    }

}