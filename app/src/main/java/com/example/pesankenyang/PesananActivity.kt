package com.example.pesankenyang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pesankenyang.room.Constan
import com.example.pesankenyang.room.Pesanan
import com.example.pesankenyang.room.PesananAdapter
import com.example.pesankenyang.room.PesananDb
import kotlinx.android.synthetic.main.activity_pesanan.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PesananActivity : AppCompatActivity() {

    val db by lazy { PesananDb(this) }
    lateinit var PesananAdapter: PesananAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesanan)
        supportActionBar?.hide()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    fun loadData() {
        CoroutineScope(Dispatchers.IO).launch {
            val pesanans = db.pesananDao().getPesanan()
            Log.d("MainActivity", "dbResponse: $pesanans")
            withContext(Dispatchers.Main) {
                PesananAdapter.setData( pesanans )
            }
        }
    }

    fun intentEdit(idOrder: Int, intentType: Int) {
        startActivity(
            Intent(applicationContext, EditPemesananActivity::class.java)
                .putExtra("intent_id", idOrder)
                .putExtra("intent_type", intentType)
        )
    }

    private fun setupRecyclerView() {
        PesananAdapter = PesananAdapter(arrayListOf(), object : PesananAdapter.OnAdapterListener {
            override fun onClick(order: Pesanan) {
                intentEdit(order.idPesanan, Constan.TYPE_READ)
            }

            override fun onUpdate(order: Pesanan) {
                intentEdit(order.idPesanan, Constan.TYPE_UPDATE)
            }

            override fun onDelete(order: Pesanan) {
                CoroutineScope(Dispatchers.IO).launch {
                    db.pesananDao().deletPesanan(order)
                    loadData()
                }
            }

        })
        listOrder.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = PesananAdapter
        }
    }
}