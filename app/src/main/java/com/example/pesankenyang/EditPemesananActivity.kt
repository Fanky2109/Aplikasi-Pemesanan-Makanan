package com.example.pesankenyang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pesankenyang.room.Constan
import com.example.pesankenyang.room.Pesanan
import com.example.pesankenyang.room.PesananDb
import kotlinx.android.synthetic.main.activity_edit_pemesanan.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditPemesananActivity : AppCompatActivity() {

    val db by lazy { PesananDb(this) }
    private var idOrder: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_pemesanan)
        supportActionBar?.hide()

        setUpView()
        ubahListener()
    }

    fun setUpView() {
        val intentType = intent.getIntExtra("intent_type", 0)
        when (intentType) {
            Constan.TYPE_READ -> {
                btn_ubah.visibility = View.GONE
                getOrder()
            }
            Constan.TYPE_UPDATE -> {
                form_makanan.visibility = View.GONE
                form_minuman.visibility = View.GONE
                getOrder()
            }
        }
    }

    fun ubahListener() {
        btn_ubah.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.pesananDao().updatePesanan(
                    Pesanan(idOrder, form_nama.text.toString(), form_makanan.text.toString(), form_minuman.text.toString())
                )
                finish()
            }
        }
    }

    fun getOrder() {
        idOrder = intent.getIntExtra("intent_id", 0)
        CoroutineScope(Dispatchers.IO).launch {
            val orders = db.pesananDao().getOrder( idOrder )[0]
            form_nama.setText( orders.namaPemesan )
            form_makanan.setText( orders.makananDipesan )
            form_minuman.setText( orders.minumanDipesan )
        }
    }
}