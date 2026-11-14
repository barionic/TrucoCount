package com.barionic.trucocount

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class TrackingRoundsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tracking_rounds)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lvHistorico)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lvHistorico = findViewById<ListView>(R.id.lvHistorico)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainActivity.historico)
        lvHistorico.setAdapter(adapter)

    }
}