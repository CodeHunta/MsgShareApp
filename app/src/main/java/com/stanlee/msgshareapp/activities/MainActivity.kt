package com.stanlee.msgshareapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.stanlee.msgshareapp.R
import com.stanlee.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            Log.i("MainActivity", "Button was clicked!")
            showToast("BUTTON WAS CLICKED!")
        }

        btnSendMsg.setOnClickListener {
            val msg: String = etUserMsg.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("key", msg)
            startActivity(intent)
        }

        btnRecycler.setOnClickListener {
            val intent = Intent(this, DestinationsActivity::class.java)
            startActivity(intent)
        }
    }
}