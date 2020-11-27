package com.fi.androidbaseproject.screen.api

import android.util.Log
import android.view.View
import com.fi.androidbaseproject.R
import com.fi.androidbaseproject.base.BaseFragment
import com.fi.androidbaseproject.models.Name
import com.google.firebase.crashlytics.internal.common.Utils
import kotlinx.android.synthetic.main.fragment_api.*
import kotlinx.android.synthetic.main.toolbar_main.*

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/06/2020, 01:56 PM
 ****************************************
 */

class ApiFragment : BaseFragment(), ApiView.View{
    private lateinit var presenter: ApiPresenter
    private val adapter = ApiAdapter()

    override fun setLayoutResource(): Int = R.layout.fragment_api

    override fun initUI() {
        activity.toolbar.title = getString(R.string.menu_api)
        pb.visibility = View.GONE
        rv.visibility = View.GONE
        tv_msg.visibility = View.GONE

        rv.adapter = adapter

        presenter = ApiPresenter(this)
        presenter.getData(activity)
    }

    override fun onProcess() {
        pb.visibility = View.VISIBLE
        rv.visibility = View.GONE
        tv_msg.visibility = View.GONE
    }

    override fun onSuccess(result: List<Name>?) {
        pb.visibility = View.GONE
        tv_msg.visibility = View.GONE
        rv.visibility = View.VISIBLE

        result?.let {
            adapter.data = it
        }
    }

    override fun onError(code: Int?, message: String) {
        pb.visibility = View.GONE
        tv_msg.visibility = View.VISIBLE
        rv.visibility = View.GONE

        tv_msg.text = message
    }

    override fun onDetach() {
        presenter.dispose()
        super.onDetach()
    }

}