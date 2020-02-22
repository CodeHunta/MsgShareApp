package com.stanlee.msgshareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            Log.i("MainActivity", "Button was clicked!")
            Toast.makeText(this, "BUTTON WAS CLICKED!", Toast.LENGTH_SHORT).show()
        }

        btnSendMsg.setOnClickListener {
            val msg: String = etUserMsg.text.toString()
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

            val intent = Intent (this, SecondActivity::class.java)
            intent.putExtra("key", msg)
            startActivity(intent)
        }

    }
}