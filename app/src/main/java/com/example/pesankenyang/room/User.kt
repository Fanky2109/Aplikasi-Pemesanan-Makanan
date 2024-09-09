package com.example.pesankenyang.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (

    @PrimaryKey(autoGenerate = true)
    val idUser : Int,
    val user : String

)