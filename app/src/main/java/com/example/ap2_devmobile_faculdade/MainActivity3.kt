package com.example.ap2_devmobile_faculdade

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val btMail = findViewById<Button>(R.id.button6)
        btMail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("ibmec@ibmec.edu.br"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Parabéns")
            intent.putExtra(Intent.EXTRA_TEXT, "Voce completou o teste!")
            startActivity(intent)
        }
    }
}