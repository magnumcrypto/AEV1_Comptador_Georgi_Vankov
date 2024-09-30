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
import com.pmdm.ieseljust.comptador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var comptador = 0
    private val TAG = "MainActivityTag"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //inicializar el objeto binding inflando la vista
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //inicializar el TextView con el valor inicial del contador
        binding.textViewComptador.text = comptador.toString()

        //configuramos los listeners para los botones usando ViewBinding
        binding.btOpen.setOnClickListener {
            val intent = Intent(baseContext, MostraComptadorActivity::class.java)
            intent.putExtra("comptador", comptador)
            startActivity(intent)
        }
        //boton sumar
        binding.btAdd.setOnClickListener {
            comptador++
            binding.textViewComptador.text = comptador.toString()
        }
        //boton restar
        binding.btSubtract.setOnClickListener {
            comptador--
            binding.textViewComptador.text = comptador.toString()
        }
        //boton resetear
        binding.btReset.setOnClickListener {
            comptador = 0
            binding.textViewComptador.text = comptador.toString()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(this.TAG, "Metodo onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(this.TAG, "Metodo onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(this.TAG, "Metodo onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(this.TAG, "Metodo onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(this.TAG, "Metodo onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(this.TAG, "Metodo onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("comptador", comptador)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        comptador = savedInstanceState.getInt("comptador")
        binding.textViewComptador.text = comptador.toString()
    }
}