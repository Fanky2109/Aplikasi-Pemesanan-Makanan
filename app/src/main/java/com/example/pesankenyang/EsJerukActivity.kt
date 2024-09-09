package com.example.pesankenyang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pesankenyang.room.Minuman
import com.example.pesankenyang.room.Pesanan
import com.example.pesankenyang.room.PesananDb
import com.example.pesankenyang.room.User
import kotlinx.android.synthetic.main.activity_es_jeruk.*
import kotlinx.android.synthetic.main.activity_es_teh.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EsJerukActivity : AppCompatActivity() {

    val db by lazy { PesananDb(this) }
    private var idOrder: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_es_jeruk)
        supportActionBar?.hide()

        btnBackListener()
        btnEsJerukListener()
    }

    private fun btnBackListener() {
        jeruk_img2.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }

    fun btnEsJerukListener() {
        btn_jeruk.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.minumanDao().addMinuman(
                    Minuman(0, jeruk_txt1.text.toString())
                )
                db.pesananDao().addPesanan(
                    Pesanan(0, nama_jeruk.text.toString(), jeruk_txt1.text.toString(), "")
                )
                db.userDao().addUser(
                    User(0, nama_jeruk.text.toString())
                )
                finish()
            }
        }
    }
}
