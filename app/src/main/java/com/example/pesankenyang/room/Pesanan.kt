package com.example.pesankenyang.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pesanan (
    @PrimaryKey(autoGenerate = true)
    val idPesanan : Int,
    val namaPemesan : String,
    val makananDipesan : String,
    val minumanDipesan : String

)