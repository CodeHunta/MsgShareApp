package com.stanlee.msgshareapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class DestinationsAdapter(private val context: Context, private val destinations: List<Destination>) : RecyclerView.Adapter<DestinationsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return destinations.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val destination = destinations[position]
        holder.setData(destination)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(destination: Destination) {
            itemView.txtTitle.text = destination.title
        }
    }
}