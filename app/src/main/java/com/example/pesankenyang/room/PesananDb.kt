package com.example.pesankenyang.room

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock

@Database(
    entities = [Makanan::class, Minuman::class, Pesanan::class, User::class],
    version = 1
)
abstract class PesananDb :RoomDatabase() {

    abstract fun makananDao() : MakananDao

    abstract fun minumanDao() : MinumanDao

    abstract fun pesananDao() : PesananDao

    abstract fun userDao() : UserDao

    companion object {

        @Volatile private var instance : PesananDb? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            PesananDb::class.java,
            "depotIjah.db"
        ).build()
    }
}

