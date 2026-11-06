package com.barionic.trucocount

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var tvNomeJogador1: TextView
    private lateinit var tvPlacarJogador1: TextView

    private lateinit var tvNomeJogador2: TextView
    private lateinit var tvPlacarJogador2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvNomeJogador1 = findViewById(R.id.tvNomeJogador1)
        tvNomeJogador2 = findViewById(R.id.tvNomeJogador2)

        val novoNome1 = intent.getStringExtra("nomeJogador1")
        val novoNome2 = intent.getStringExtra("nomeJogador2")

        if (novoNome1 !== null && novoNome2 !== null){
            tvNomeJogador1.text = "$novoNome1 :"
            tvNomeJogador2.text = "$novoNome2 :"
        }
    }

    fun btAlterarNomeOnClick(view: View) {
        val intent = Intent(this, ChangeNameActivity::class.java)
        startActivity(intent)
    }
}