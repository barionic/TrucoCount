package com.barionic.trucocount

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
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

    private lateinit var bt1Jog1: Button
    private lateinit var bt3Jog1: Button
    private lateinit var bt6Jog1: Button
    private lateinit var bt9Jog1: Button
    private lateinit var bt12Jog1: Button

    private lateinit var bt1Jog2: Button
    private lateinit var bt3Jog2: Button
    private lateinit var bt6Jog2: Button
    private lateinit var bt9Jog2: Button
    private lateinit var bt12Jog2: Button

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

        tvPlacarJogador1 = findViewById(R.id.tvPlacarJogador1)
        tvPlacarJogador2 = findViewById(R.id.tvPlacarJogador2)

        bt1Jog1 = findViewById(R.id.bt1Jog1)
        bt3Jog1 = findViewById(R.id.bt3Jog1)
        bt6Jog1 = findViewById(R.id.bt6Jog1)
        bt9Jog1 = findViewById(R.id.bt9Jog1)
        bt12Jog1 = findViewById(R.id.bt12Jog1)

        bt1Jog2 = findViewById(R.id.bt1Jog2)
        bt3Jog2 = findViewById(R.id.bt3Jog2)
        bt6Jog2 = findViewById(R.id.bt6Jog2)
        bt9Jog2 = findViewById(R.id.bt9Jog2)
        bt12Jog2 = findViewById(R.id.bt12Jog2)

        var placarJogador1 = 0
        var placarJogador2 = 0

        bt1Jog1.setOnClickListener{
            placarJogador1++
            tvPlacarJogador1.text = placarJogador1.toString()
        }

        bt1Jog2.setOnClickListener{
            placarJogador2++
            tvPlacarJogador2.text = placarJogador2.toString()
        }

    }

    fun btAlterarNomeOnClick(view: View) {
        val intent = Intent(this, ChangeNameActivity::class.java)
        startActivity(intent)
    }
}