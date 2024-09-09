package com.example.pesankenyang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        supportActionBar?.hide()

        btnBackListener()
        btnNasiGorengListener()
        btnNasiPecelListener()
        btnTehListener()
        btnJerukListener()
        btnDaftarOrder()
    }

    private fun btnBackListener() {
        m_img2.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun btnNasiGorengListener() {
        m_btn1.setOnClickListener {
            startActivity(Intent(this, NasiGorengActivity::class.java))
        }
    }

    private fun btnNasiPecelListener() {
        m_btn2.setOnClickListener {
            startActivity(Intent(this, NasiPecelActivity::class.java))
        }
    }

    private fun btnTehListener() {
        m_btn3.setOnClickListener {
            startActivity(Intent(this, EsTehActivity::class.java))
        }
    }

    private fun btnJerukListener() {
        m_btn4.setOnClickListener {
            startActivity(Intent(this, EsJerukActivity::class.java))
        }
    }

    private fun btnDaftarOrder() {
        m_btn5.setOnClickListener {
            startActivity(Intent(this, PesananActivity::class.java))
        }
    }
}