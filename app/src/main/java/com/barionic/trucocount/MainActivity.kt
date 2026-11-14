package com.barionic.trucocount

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var vitoriasJogador1 = 0
    var vitoriasJogador2 = 0

    var placarJogador1 = 0
    var placarJogador2 = 0


    private lateinit var tvNomeJogador1: TextView
    private lateinit var tvPlacarJogador1: TextView
    private lateinit var tvPlacarVitoriasJogador1: TextView

    private lateinit var tvNomeJogador2: TextView
    private lateinit var tvPlacarJogador2: TextView
    private lateinit var tvPlacarVitoriasJogador2: TextView

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
        tvPlacarJogador1 = findViewById(R.id.tvPlacarJogador1)
        tvPlacarJogador2 = findViewById(R.id.tvPlacarJogador2)
        tvPlacarVitoriasJogador1 = findViewById(R.id.tvPlacarVitoriasJogador1)
        tvPlacarVitoriasJogador2 = findViewById(R.id.tvPlacarVitoriasJogador2)

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

        btZerarHistorico = findViewById(R.id.btZerarHistorico)


        bt1Jog1.setOnClickListener {
            placarJogador1++
            tvPlacarJogador1.text = placarJogador1.toString()
            verificarVencedor(tvNomeJogador1.text.toString(), tvNomeJogador2.text.toString())
        }

        bt1Jog2.setOnClickListener {
            placarJogador2++
            tvPlacarJogador2.text = placarJogador2.toString()
            verificarVencedor(tvNomeJogador1.text.toString(), tvNomeJogador2.text.toString())
        }

        bt3Jog1.setOnClickListener {
            placarJogador1 += 3
            tvPlacarJogador1.text = placarJogador1.toString()
            verificarVencedor(tvNomeJogador1.text.toString(), tvNomeJogador2.text.toString())
        }

        bt3Jog2.setOnClickListener {
            placarJogador2 += 3
            tvPlacarJogador2.text = placarJogador2.toString()
            verificarVencedor(tvNomeJogador1.text.toString(), tvNomeJogador2.text.toString())
        }

        bt6Jog1.setOnClickListener {
            placarJogador1 += 6
            tvPlacarJogador1.text = placarJogador1.toString()
            verificarVencedor(tvNomeJogador1.text.toString(), tvNomeJogador2.text.toString())
        }

        bt6Jog2.setOnClickListener {
            placarJogador2 += 6
            tvPlacarJogador2.text = placarJogador2.toString()
            verificarVencedor(tvNomeJogador1.text.toString(), tvNomeJogador2.text.toString())
        }

        bt9Jog1.setOnClickListener {
            placarJogador1 += 9
            tvPlacarJogador1.text = placarJogador1.toString()
            verificarVencedor(tvNomeJogador1.text.toString(), tvNomeJogador2.text.toString())
        }

        bt9Jog2.setOnClickListener {
            placarJogador2 += 9
            tvPlacarJogador2.text = placarJogador2.toString()
            verificarVencedor(tvNomeJogador1.text.toString(), tvNomeJogador2.text.toString())
        }

        bt12Jog1.setOnClickListener {
            placarJogador1 += 12
            tvPlacarJogador1.text = placarJogador1.toString()
            verificarVencedor(tvNomeJogador1.text.toString(), tvNomeJogador2.text.toString())
        }

        bt12Jog2.setOnClickListener {
            placarJogador2 += 12
            tvPlacarJogador2.text = placarJogador2.toString()
            verificarVencedor(tvNomeJogador1.text.toString(), tvNomeJogador2.text.toString())
        }

        btZerarHistorico.setOnClickListener {
            vitoriasJogador1 = 0
            tvPlacarVitoriasJogador1.text = vitoriasJogador1.toString()
            vitoriasJogador2 = 0
            tvPlacarVitoriasJogador2.text = vitoriasJogador2.toString()

            zerarPlacar()
        }

    }


    fun verificarVencedor(nomeJogador1: String, nomeJogador2: String){
        if (placarJogador1 >= 12 || placarJogador2 >= 12) {
            if (placarJogador1 >= 12) {
                Toast.makeText(this, "${nomeJogador1} Venceu!", Toast.LENGTH_LONG).show()
                vitoriasJogador1++
                tvPlacarVitoriasJogador1.text = vitoriasJogador1.toString()
            }
            if (placarJogador2 >= 12) {
                Toast.makeText(this, "${nomeJogador2} Venceu!", Toast.LENGTH_LONG).show()
                vitoriasJogador2++
                tvPlacarVitoriasJogador2.text = vitoriasJogador2.toString()
            }

            zerarPlacar()
        }
    }

    fun zerarPlacar(){
        placarJogador1 = 0
        tvPlacarJogador1.text = placarJogador1.toString()
        placarJogador2 = 0
        tvPlacarJogador2.text = placarJogador2.toString()
    }

    fun btAlterarNomeOnClick(view: View) {
        val intent = Intent(this, ChangeNameActivity::class.java)
        getResult.launch(intent)
    }

    private val getResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ resultado ->
            if(resultado.resultCode == RESULT_OK){
                val novoNome1 = resultado.data?.getStringExtra("nomeJogador1")
                val novoNome2 = resultado.data?.getStringExtra("nomeJogador2")
                tvNomeJogador1.setText("$novoNome1 : ")
                tvNomeJogador2.setText("$novoNome2 : ")
            }
        }

    fun btHistoricoJogadas(view: View) {
        val intent = Intent(this, TrackingRoundsActivity::class.java)
        startActivity(intent)
        //TODO: levar jogadas feitas aqui para o histórico
        //TODO: garantir placar intacto ao visualizar histórico
    }


}