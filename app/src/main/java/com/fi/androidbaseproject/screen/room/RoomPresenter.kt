package com.fi.androidbaseproject.screen.room

import com.fi.androidbaseproject.models.Name
import com.fi.androidbaseproject.base.BaseStorage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

30/06/2020, 11:48 AM
 ****************************************
 */

class RoomPresenter(
    private val view: RoomView.View
) : RoomView.Presenter {

    private var mCompositeDisposable = CompositeDisposable()

    override fun saveData(db: BaseStorage, name: Name) {
        mCompositeDisposable.add(
            db.nameDao().insertAll(name)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    view.onSaveSuccess()
                }, {
                    view.onSaveError(it.message.toString())
                })
        )
    }

    override fun getData(db: BaseStorage) {
        mCompositeDisposable.add(
            db.nameDao().getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    view.onGetDataSuccess(it)
                }, {
                    view.onGetDataError(it.message.toString())
                })
        )
    }

    override fun dispose() {
        mCompositeDisposable.dispose()
    }
}