package com.pmdm.ieseljust.comptador

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var comptador = 0
    /*override fun onStart() {
        super.onStart()
        Log.d(TAG, "Al mètode onStart") // TAG és una etiqueta prèviament definida
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencia al TextView
        val textViewContador = findViewById<TextView>(R.id.textViewComptador)
        // Referencia al boto d'Open
        val btnSubtract = findViewById<Button>(R.id.btSubtract)
        // Referencia al boton de Reet
        val btnReset = findViewById<Button>(R.id.btReset)
        // Referencia al botón
        val btAdd = findViewById<Button>(R.id.btAdd)
        // Referencia al boton de Open
        val btnOpen = findViewById<Button>(R.id.btOpen)

        // Inicialitzem el TextView amb el comptador a 0
        textViewContador.text =
            comptador.toString() // Estem fent una assignacio directament o accedinta algun metode?


        //Evento para el boton Open para lanzar el Intent
        btnOpen.setOnClickListener {
            val intent = Intent(baseContext, MostraComptadorActivity::class.java)
            intent.putExtra("comptador", comptador)
            startActivity(intent)
        }

        // Asociaciamos una expresióin lambda como
        // respuesta (callback) al evento Clic sobre
        // el botón
        btAdd.setOnClickListener {
            comptador++
            textViewContador.text = comptador.toString()
        }

        btnSubtract.setOnClickListener {
            comptador--
            textViewContador.text = comptador.toString()
        }

        btnReset.setOnClickListener {
            comptador = 0
            textViewContador.text = comptador.toString()
        }

        /*btOpen.setOnClickListener{
            val intent = Intent(baseContext, MostraComptadorActivity::class.java)
            intent.putExtra("comptador", comptador)
            startActivity(intent)
        }*/

        /*btOpen.setOnClickListener {
            Intent(baseContext, MostraComptadorActivity::class.java).apply {
                putExtra("comptador", comptador)
                startActivity(this)
            }
        }*/


    }
}