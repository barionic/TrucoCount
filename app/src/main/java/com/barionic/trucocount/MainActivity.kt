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
import kotlin.toString

class MainActivity : AppCompatActivity() {

    private lateinit var tvNomeJogador1: TextView
    private lateinit var tvPlacarJogador1: TextView

    private lateinit var tvNomeJogador2: TextView
    private lateinit var tvPlacarJogador2: TextView

    private lateinit var btZerarHistorico: Button

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

        btZerarHistorico = findViewById(R.id.btZerarHistorico)

        bt1Jog2 = findViewById(R.id.bt1Jog2)
        bt3Jog2 = findViewById(R.id.bt3Jog2)
        bt6Jog2 = findViewById(R.id.bt6Jog2)
        bt9Jog2 = findViewById(R.id.bt9Jog2)
        bt12Jog2 = findViewById(R.id.bt12Jog2)

        var vitoriasJogador1 = 0
        var vitoriasJogador2 = 0

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

        bt3Jog1.setOnClickListener{
            placarJogador1+=3
            tvPlacarJogador1.text = placarJogador1.toString()
        }

        bt3Jog2.setOnClickListener{
            placarJogador2+=3
            tvPlacarJogador2.text = placarJogador2.toString()
        }

        bt6Jog1.setOnClickListener{
            placarJogador1+=6
            tvPlacarJogador1.text = placarJogador1.toString()
        }

        bt6Jog2.setOnClickListener{
            placarJogador2+=6
            tvPlacarJogador2.text = placarJogador2.toString()
        }

        bt9Jog1.setOnClickListener{
            placarJogador1+=9
            tvPlacarJogador1.text = placarJogador1.toString()
        }

        bt9Jog2.setOnClickListener{
            placarJogador2+=9
            tvPlacarJogador2.text = placarJogador2.toString()
        }

        bt12Jog1.setOnClickListener{
            placarJogador1+=12
            tvPlacarJogador1.text = placarJogador1.toString()
        }

        bt12Jog2.setOnClickListener{
            placarJogador2+=12
            tvPlacarJogador2.text = placarJogador2.toString()
        }

        btZerarHistorico.setOnClickListener {
             vitoriasJogador1 = 0
             vitoriasJogador2 = 0

             placarJogador1 = 0
             tvPlacarJogador1.text = placarJogador1.toString()
             placarJogador2 = 0
             tvPlacarJogador2.text = placarJogador2.toString()
        }

    }

    fun btAlterarNomeOnClick(view: View) {
        val intent = Intent(this, ChangeNameActivity::class.java)
        startActivity(intent)
    }

}