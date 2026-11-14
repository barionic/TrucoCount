package com.barionic.trucocount

import android.content.Intent
import android.os.Bundle
import android.view.View
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
            placarJogador1++
            historico.add("${binding.tvNomeJogador1.text} marcou +1 pontos")
            binding.tvPlacarJogador1.text = placarJogador1.toString()
            verificarVencedor(binding.tvNomeJogador1.text.toString(), binding.tvNomeJogador2.text.toString())
        }

        binding.bt1Jog2.setOnClickListener {
            placarJogador2++
            historico.add("${binding.tvNomeJogador2.text} marcou +1 pontos")
            binding.tvPlacarJogador2.text = placarJogador2.toString()
            verificarVencedor(binding.tvNomeJogador1.text.toString(), binding.tvNomeJogador2.text.toString())
        }

        binding.bt3Jog1.setOnClickListener {
            placarJogador1 += 3
            historico.add("${binding.tvNomeJogador1.text} marcou +3 pontos")
            binding.tvPlacarJogador1.text = placarJogador1.toString()
            verificarVencedor(binding.tvNomeJogador1.text.toString(), binding.tvNomeJogador2.text.toString())
        }

        binding.bt3Jog2.setOnClickListener {
            placarJogador2 += 3
            historico.add("${binding.tvNomeJogador2.text} marcou +3 pontos")
            binding.tvPlacarJogador2.text = placarJogador2.toString()
            verificarVencedor(binding.tvNomeJogador1.text.toString(), binding.tvNomeJogador2.text.toString())
        }

        binding.bt6Jog1.setOnClickListener {
            placarJogador1 += 6
            historico.add("${binding.tvNomeJogador1.text} marcou +6 pontos")
            binding.tvPlacarJogador1.text = placarJogador1.toString()
            verificarVencedor(binding.tvNomeJogador1.text.toString(), binding.tvNomeJogador2.text.toString())
        }

        binding.bt6Jog2.setOnClickListener {
            placarJogador2 += 6
            historico.add("${binding.tvNomeJogador2.text} marcou +6 pontos")
            binding.tvPlacarJogador2.text = placarJogador2.toString()
            verificarVencedor(binding.tvNomeJogador1.text.toString(), binding.tvNomeJogador2.text.toString())
        }

        binding.bt9Jog1.setOnClickListener {
            placarJogador1 += 9
            historico.add("${binding.tvNomeJogador1.text} marcou +9 pontos")
            binding.tvPlacarJogador1.text = placarJogador1.toString()
            verificarVencedor(binding.tvNomeJogador1.text.toString(), binding.tvNomeJogador2.text.toString())
        }

        binding.bt9Jog2.setOnClickListener {
            placarJogador2 += 9
            historico.add("${binding.tvNomeJogador2.text} marcou +9 pontos")
            binding.tvPlacarJogador2.text = placarJogador2.toString()
            verificarVencedor(binding.tvNomeJogador1.text.toString(), binding.tvNomeJogador2.text.toString())
        }

        binding.bt12Jog1.setOnClickListener {
            placarJogador1 += 12
            historico.add("${binding.tvNomeJogador1.text} marcou +12 pontos")
            binding.tvPlacarJogador1.text = placarJogador1.toString()
            verificarVencedor(binding.tvNomeJogador1.text.toString(), binding.tvNomeJogador2.text.toString())
        }

        binding.bt12Jog2.setOnClickListener {
            placarJogador2 += 12
            historico.add("${binding.tvNomeJogador2.text} marcou +12 pontos")
            binding.tvPlacarJogador2.text = placarJogador2.toString()
            verificarVencedor(binding.tvNomeJogador1.text.toString(), binding.tvNomeJogador2.text.toString())
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

    fun verificarVencedor(nomeJogador1: String, nomeJogador2: String){
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

    fun zerarPlacar(){
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
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ resultado ->
            if(resultado.resultCode == RESULT_OK){
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

    companion object{
        val historico = mutableListOf<String>()
    }

}