package com.example.pesankenyang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pesankenyang.room.*
import kotlinx.android.synthetic.main.activity_es_jeruk.*
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.activity_nasi_goreng.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NasiGorengActivity : AppCompatActivity() {

    val db by lazy { PesananDb(this) }
    private var idOrder: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nasi_goreng)
        supportActionBar?.hide()

        btnBackListener()
        btnNasiGorengListener()
    }

    private fun btnBackListener() {
        nasi_img2.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }

    fun btnNasiGorengListener() {
        btn_nasigoreng.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.makananDao().addMakanan(
                    Makanan(0, nasi_txt1.text.toString())
                )
                db.pesananDao().addPesanan(
                    Pesanan(0, nama_nasi_goreng.text.toString(), nasi_txt1.text.toString(), "")
                )
                db.userDao().addUser(
                    User(0, nama_nasi_goreng.text.toString())
                )
                finish()
            }
        }
    }
}