package com.barionic.trucocount

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.barionic.trucocount.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var vitoriasJogador1 = 0
    var vitoriasJogador2 = 0

    var placarJogador1 = 0
    var placarJogador2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.bt1Jog1.setOnClickListener {
            fazerPonto(1, binding.tvNomeJogador1)
        }

        binding.bt1Jog2.setOnClickListener {
            fazerPonto(1, binding.tvNomeJogador2)
        }

        binding.bt3Jog1.setOnClickListener {
            fazerPonto(3, binding.tvNomeJogador1)
        }

        binding.bt3Jog2.setOnClickListener {
            fazerPonto(3, binding.tvNomeJogador2)
        }

        binding.bt6Jog1.setOnClickListener {
            fazerPonto(6, binding.tvNomeJogador1)
        }

        binding.bt6Jog2.setOnClickListener {
            fazerPonto(6, binding.tvNomeJogador2)
        }

        binding.bt9Jog1.setOnClickListener {
            fazerPonto(9, binding.tvNomeJogador1)
        }

        binding.bt9Jog2.setOnClickListener {
            fazerPonto(9, binding.tvNomeJogador2)
        }

        binding.bt12Jog1.setOnClickListener {
            fazerPonto(12, binding.tvNomeJogador1)
        }

        binding.bt12Jog2.setOnClickListener {
            fazerPonto(12, binding.tvNomeJogador2)
        }

        binding.btZerarHistorico.setOnClickListener {
            vitoriasJogador1 = 0
            binding.tvPlacarVitoriasJogador1.text = vitoriasJogador1.toString()
            vitoriasJogador2 = 0
            binding.tvPlacarVitoriasJogador2.text = vitoriasJogador2.toString()
            historico.clear()
            zerarPlacar()
        }

    }

    fun verificarVencedor(nomeJogador1: String, nomeJogador2: String) {
        if (placarJogador1 >= 12 || placarJogador2 >= 12) {
            if (placarJogador1 >= 12) {
                Toast.makeText(this, "${nomeJogador1} Venceu!", Toast.LENGTH_LONG).show()
                vitoriasJogador1++
                historico.add("${binding.tvNomeJogador1.text} ganhou a partida!")
                binding.tvPlacarVitoriasJogador1.text = vitoriasJogador1.toString()
            }
            if (placarJogador2 >= 12) {
                Toast.makeText(this, "${nomeJogador2} Venceu!", Toast.LENGTH_LONG).show()
                vitoriasJogador2++
                historico.add("${binding.tvNomeJogador2.text} ganhou a partida!")
                binding.tvPlacarVitoriasJogador2.text = vitoriasJogador2.toString()
            }

            zerarPlacar()
        }
    }

    fun zerarPlacar() {
        placarJogador1 = 0
        binding.tvPlacarJogador1.text = placarJogador1.toString()
        placarJogador2 = 0
        binding.tvPlacarJogador2.text = placarJogador2.toString()
    }

    fun btAlterarNomeOnClick(view: View) {
        val intent = Intent(this, ChangeNameActivity::class.java)
        getResult.launch(intent)
    }

    private val getResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { resultado ->
            if (resultado.resultCode == RESULT_OK) {
                val novoNome1 = resultado.data?.getStringExtra("nomeJogador1")
                val novoNome2 = resultado.data?.getStringExtra("nomeJogador2")
                binding.tvNomeJogador1.setText("$novoNome1 : ")
                binding.tvNomeJogador2.setText("$novoNome2 : ")
            }
        }

    fun btHistoricoJogadas(view: View) {
        val intent = Intent(this, TrackingRoundsActivity::class.java)
        startActivity(intent)
    }

    fun fazerPonto(ponto: Int, nomeJogador: TextView) {
        if (nomeJogador == binding.tvNomeJogador1) {
            placarJogador1 += ponto
            historico.add("${nomeJogador.text} marcou +${ponto} pontos")
            binding.tvPlacarJogador1.text = placarJogador1.toString()
            verificarVencedor(
                binding.tvNomeJogador1.text.toString(),
                binding.tvNomeJogador2.text.toString()
            )
        }
        if (nomeJogador == binding.tvNomeJogador2) {
            placarJogador2 += ponto
            historico.add("${nomeJogador.text} marcou +${ponto} pontos")
            binding.tvPlacarJogador2.text = placarJogador2.toString()
            verificarVencedor(
                binding.tvNomeJogador1.text.toString(),
                binding.tvNomeJogador2.text.toString()
            )
        }

        //TODO: melhorar design do app começando pelo visuais dos buttons e ListView, depois font e backgrounds

    }

    companion object {
        val historico = mutableListOf<String>()
    }

}