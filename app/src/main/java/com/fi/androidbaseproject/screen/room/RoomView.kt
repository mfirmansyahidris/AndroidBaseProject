package com.fi.androidbaseproject.screen.room

import com.fi.androidbaseproject.models.Name
import com.fi.androidbaseproject.base.BaseStorage

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

30/06/2020, 11:48 AM
 ****************************************
 */

interface RoomView {
    interface View {
        fun onSaveSuccess()
        fun onSaveError(message: String)

        fun onGetDataSuccess(data: List<Name>)
        fun onGetDataError(message: String)
    }

    interface Presenter {
        fun saveData(db: BaseStorage, name: Name)
        fun getData(db: BaseStorage)
        fun dispose()
    }
}