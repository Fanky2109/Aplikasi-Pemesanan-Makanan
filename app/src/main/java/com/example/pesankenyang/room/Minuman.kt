package com.example.pesankenyang.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Minuman (

    @PrimaryKey(autoGenerate = true)
    val idMinuman : Int,
    val minuman : String

)