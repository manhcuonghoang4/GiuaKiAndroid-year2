package com.example.giuaky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_singnup.*

class MainActivity : AppCompatActivity() {
    private  lateinit var btnDangKy: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDangKy = findViewById(R.id.btnDangky)
        btnDangKy.setOnClickListener {
            val intent = Intent(this, singnup::class.java)
            startActivity(intent)
        }
    }
}