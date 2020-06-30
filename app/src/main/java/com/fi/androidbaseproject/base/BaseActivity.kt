package com.fi.androidbaseproject.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.fi.androidbaseproject.R
import com.fi.androidbaseproject.utils.PrefManager

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/06/2020, 11:43 AM
 ****************************************
 */

abstract class BaseActivity : AppCompatActivity() {
    protected var toolbar: Toolbar? = null
    protected lateinit var prefManager: PrefManager
    protected lateinit var db: BaseStorage

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutResource())
        if (setToolbarResource() != 0) {
            toolbar = findViewById(setToolbarResource())
            setSupportActionBar(toolbar)
            supportActionBar?.setDefaultDisplayHomeAsUpEnabled(setToolbarActionButton())
            supportActionBar?.setDisplayHomeAsUpEnabled(setToolbarActionButton())
        }
        prefManager = PrefManager(this)
        db = BaseStorage(this)

        initUI()
    }

    protected abstract fun setLayoutResource(): Int
    protected abstract fun setToolbarResource(): Int
    protected abstract fun setToolbarActionButton(): Boolean
    protected abstract fun initUI()

    protected fun showDialogPositiveNeutral(message: String, listener: (Boolean) -> Unit) {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage(message)

        val alert = alertDialogBuilder.create()

        alert.setButton(
            AlertDialog.BUTTON_POSITIVE,
            getString(R.string.dialog_btn_no)
        ) { _, _ ->
            listener(false)
        }
        alert.setButton(AlertDialog.BUTTON_NEUTRAL, getString(R.string.dialog_btn_yes)) { _, _ ->
            listener(true)
        }
        alert.setCancelable(true)
        alert.show()
    }

    protected fun showDialogPositive(message: String, listener: (Boolean) -> Unit) {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage(message)

        val alert = alertDialogBuilder.create()

        alert.setButton(
            AlertDialog.BUTTON_POSITIVE,
            getString(R.string.dialog_btn_ok)
        ) { _, _ -> }

        alert.setOnDismissListener { listener(true) }

        alert.setCancelable(true)
        alert.show()
    }

}