package com.stanlee.msgshareapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.stanlee.msgshareapp.R
import com.stanlee.msgshareapp.adaptors.DestinationsAdapter
import com.stanlee.msgshareapp.models.Places
import kotlinx.android.synthetic.main.activity_destinations.*

class DestinationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destinations)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adapter = DestinationsAdapter(this, Places.destinations)
        recyclerView.adapter = adapter
    }
}
