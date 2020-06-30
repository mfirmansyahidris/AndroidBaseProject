package com.fi.androidbaseproject.dao

import androidx.room.*
import com.fi.androidbaseproject.models.Name
import io.reactivex.Completable
import io.reactivex.Observable

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

30/06/2020, 10:39 AM
 ****************************************
 */

@Dao
interface NameDao{
    @Query("SELECT * FROM name")
    fun getAll(): Observable<List<Name>>

    @Insert
    fun insertAll(vararg name: Name): Completable

    @Delete
    fun delete(name: Name)

    @Update
    fun update(vararg name: Name)
}