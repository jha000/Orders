package com.example.realtimerecycleview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.realtimerecycleview.MyAdapter.MyViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import java.util.ArrayList

class MyAdapter(private val context: Context, var list: ArrayList<User?>?) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = list[position]
        holder.Product.text = user.product
        holder.name1.text = user.name
        holder.mobile1.text = user.mobile
        holder.address1.text = user.address
        holder.amount.text = user.amount
        holder.quantity.text = user.quantity
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun searchDataList(searchList: ArrayList<User?>) {
        list = searchList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Product: TextView
        var amount: TextView
        var name1: TextView
        var mobile1: TextView
        var address1: TextView
        var quantity: TextView
        var card: CardView? = null

        init {
            Product = itemView.findViewById(R.id.tvfirstName)
            amount = itemView.findViewById(R.id.tvage)
            name1 = itemView.findViewById(R.id.nameid)
            mobile1 = itemView.findViewById(R.id.mobileid)
            address1 = itemView.findViewById(R.id.addressid)
            quantity = itemView.findViewById(R.id.tvqty)
        }
    }
}