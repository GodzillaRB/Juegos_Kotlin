package com.example.juegos_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.juegos_kotlin.adivinanumero.AdivinaNumeroActivity
import com.example.juegos_kotlin.ahorcado.AhorcadoActivity
import com.example.juegos_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnAdivinarNumero.setOnClickListener(){
            val objIntent: Intent = Intent (this, AdivinaNumeroActivity::class.java)
            startActivity(objIntent)
        }

        binding.btnAhorcado.setOnClickListener(){
            val Intent: Intent = Intent (this, AhorcadoActivity::class.java)
            startActivity(Intent)
        }
    }


}