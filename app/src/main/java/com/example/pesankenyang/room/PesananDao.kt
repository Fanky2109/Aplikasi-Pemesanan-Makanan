package com.example.pesankenyang.room

import androidx.room.*

@Dao
interface PesananDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPesanan(pesanan: Pesanan)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updatePesanan(pesanan: Pesanan)

    @Delete
    fun deletPesanan(pesanan: Pesanan)

    @Query("SELECT * FROM [pesanan]")
    fun getPesanan() : List<Pesanan>

    @Query("SELECT * FROM [pesanan] WHERE idPesanan=:id_order")
    fun getOrder(id_order: Int): List<Pesanan>
}