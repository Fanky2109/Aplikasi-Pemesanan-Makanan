package com.example.pesankenyang.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface MinumanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMinuman(minuman: Minuman)

}