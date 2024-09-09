package com.example.pesankenyang.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface MakananDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMakanan(makanan: Makanan)

}