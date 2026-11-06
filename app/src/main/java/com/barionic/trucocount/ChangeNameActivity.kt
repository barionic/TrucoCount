package com.barionic.trucocount

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChangeNameActivity : AppCompatActivity() {

    private lateinit var etJogador1: EditText
    private lateinit var etJogador2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_change_name)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etJogador1 = findViewById(R.id.etJogador1)
        etJogador2 = findViewById(R.id.etJogador2)
    }

    fun btConfirmarOnClick(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("nomeJogador1", etJogador1.text.toString())
        intent.putExtra("nomeJogador2", etJogador2.text.toString())
        startActivity(intent)
    }
}