package com.stanlee.msgshareapp.adaptors

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.stanlee.msgshareapp.R
import com.stanlee.msgshareapp.models.Destination
import com.stanlee.msgshareapp.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class DestinationsAdapter(
    private val context: Context,
    private val destinations: List<Destination>
) : RecyclerView.Adapter<DestinationsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return destinations.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val destination = destinations[position]
        holder.setData(destination, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var currentDestination: Destination? = null
        private var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                context.showToast(currentDestination!!.title + " State was clicked!", Toast.LENGTH_LONG)
            }

            itemView.imgShare.setOnClickListener {
                val msg: String = "My Current Location is " + currentDestination!!.title + " State!"
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, msg)
                intent.type = "text/plain"
                context.startActivity(Intent.createChooser(intent, "Share to: "))
            }
        }

        fun setData(destination: Destination?, pos: Int) {
            itemView.txtTitle.text = destination!!.title

            this.currentDestination = destination
            this.currentPosition = pos
        }
    }
}