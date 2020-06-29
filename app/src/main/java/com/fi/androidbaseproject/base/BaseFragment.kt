package com.fi.androidbaseproject.base

import android.content.Context
import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.fi.androidbaseproject.R
import com.fi.androidbaseproject.utils.Utils

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/06/2020, 11:43 AM
 ****************************************
 */

abstract class BaseFragment : Fragment() {
    protected lateinit var activity: AppCompatActivity

    protected abstract fun getLayoutResource(): Int

    protected abstract fun getToolbarColor(): Int?

    protected abstract fun mainCode()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        return inflater.inflate(getLayoutResource(), container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        d(Utils.tag, getToolbarColor().toString())

        mainCode()

        if (getToolbarColor() == null) {
            activity.window.statusBarColor =
                ContextCompat.getColor(activity, R.color.colorPrimaryDark)

        } else {
            getToolbarColor()?.let {
                activity.window.statusBarColor = it
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as AppCompatActivity
    }

}