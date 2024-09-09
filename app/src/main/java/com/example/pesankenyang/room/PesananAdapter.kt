package com.example.pesankenyang.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pesankenyang.R
import kotlinx.android.synthetic.main.pesanan_adapter.view.*

class PesananAdapter(private  val pesanans: ArrayList<Pesanan>, private val listener: OnAdapterListener)
    : RecyclerView.Adapter<PesananAdapter.OrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        return OrderViewHolder(
            LayoutInflater.from(parent.context).inflate( R.layout.pesanan_adapter, parent, false )
        )
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val pesanan = pesanans[position]
        holder.view.textOrder.text = pesanan.namaPemesan
        holder.view.textOrder.setOnClickListener {
            listener.onClick( pesanan )
        }
        holder.view.icon_edit.setOnClickListener {
            listener.onUpdate( pesanan )
        }
        holder.view.icon_delete.setOnClickListener {
            listener.onDelete( pesanan )
        }
    }

    override fun getItemCount() = pesanans.size

    class OrderViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<Pesanan>) {
        pesanans.clear()
        pesanans.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(order: Pesanan)
        fun onUpdate(order: Pesanan)
        fun onDelete(order: Pesanan)
    }

}