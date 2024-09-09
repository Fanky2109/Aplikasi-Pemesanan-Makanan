package com.example.pesankenyang.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Makanan (

    @PrimaryKey(autoGenerate = true)
    val idMakanan :Int,
    val makanan :String

)