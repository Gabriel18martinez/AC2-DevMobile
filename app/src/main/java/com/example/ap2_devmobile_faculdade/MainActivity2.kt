package com.example.ap2_devmobile_faculdade

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val botao = findViewById<Button>(R.id.button)
        botao.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val buttonweb = findViewById<ImageButton>(R.id.imageButton)
        buttonweb.setOnClickListener {
            val webpage = Uri.parse("https://www.bancopaulista.com.br")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }
    }
}