package com.fi.androidbaseproject.utils

import androidx.room.*
import com.fi.androidbaseproject.models.Name

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
    fun getAll(): List<Name>

    @Insert
    fun insertAll(vararg name: Name)

    @Delete
    fun delete(name: Name)

    @Update
    fun update(vararg name: Name)
}