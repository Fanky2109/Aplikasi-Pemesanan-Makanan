package com.example.pesankenyang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pesankenyang.room.Makanan
import com.example.pesankenyang.room.Pesanan
import com.example.pesankenyang.room.PesananDb
import com.example.pesankenyang.room.User
import kotlinx.android.synthetic.main.activity_nasi_goreng.*
import kotlinx.android.synthetic.main.activity_nasi_pecel.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NasiPecelActivity : AppCompatActivity() {

    val db by lazy { PesananDb(this) }
    private var idOrder: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nasi_pecel)
        supportActionBar?.hide()

        btnBackListener()
        btnNasiPecelListener()
    }

    private fun btnBackListener() {
        pecel_img2.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }

    fun btnNasiPecelListener() {
        btn_nasipecel.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.makananDao().addMakanan(
                    Makanan(0, pecel_txt1.text.toString())
                )
                db.pesananDao().addPesanan(
                    Pesanan(0, nama_pecel.text.toString(), pecel_txt1.text.toString(), "")
                )
                db.userDao().addUser(
                    User(0, nama_pecel.text.toString())
                )
                finish()
            }
        }
    }
}