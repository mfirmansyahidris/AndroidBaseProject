package com.fi.androidbaseproject.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fi.androidbaseproject.utils.PrefManager

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/06/2020, 11:43 AM
 ****************************************
 */

abstract class BaseFragment : Fragment() {
    protected lateinit var activity: AppCompatActivity
    protected lateinit var prefManager: PrefManager
    protected lateinit var db: BaseStorage

    protected abstract fun setLayoutResource(): Int

    protected abstract fun initUI()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        return inflater.inflate(setLayoutResource(), container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefManager = PrefManager(activity)
        db = BaseStorage(activity)
        initUI()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as AppCompatActivity
    }

}