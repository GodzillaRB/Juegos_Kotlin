package com.example.juegos_kotlin.ahorcado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.juegos_kotlin.R
import com.example.juegos_kotlin.databinding.ActivityAhorcadoBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AhorcadoActivity : AppCompatActivity() {
    private lateinit var game: Game
    private lateinit var letters: Letters
    private lateinit var binding: ActivityAhorcadoBinding
    private lateinit var imagenes: IntArray
    private lateinit var btnPressList: MutableList<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAhorcadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnPressList = mutableListOf()
        letters = Letters()
        game = Game(letters.getLettersRandom())
        appLoad()
    }

    fun reloadGame() {
        game = Game(letters.getLettersRandom())
        appLoad()
        changeStateButton()
    }

    fun appLoad() {
        var palabra = game.dibujarPalabraAdivinada()

        imagenes = intArrayOf(
            R.drawable.intento5,
            R.drawable.intento4,
            R.drawable.intento3,
            R.drawable.intento2,
            R.drawable.intento1,
            R.drawable.intento0,
            R.drawable.inicio
        )
        with(binding) {
            changeIMG(imagenes[6])
            palabraSecreta.text = palabra
        }


    }

    fun changeIMG(i: Int) {
        with(binding) {
            ahorcado.setImageDrawable(getDrawable(i))
        }

    }

    fun writeLetter(view: View) {
        var letter = view.contentDescription[0]
        game.intentarLetra(letter)
        changeIMG(imagenes[game.intentosRestantes])
        changeText(game.dibujarPalabraAdivinada())
        view.isEnabled = false
        addLetterOnClick(view)
        if (game.estaCompleto()) {
            checkResult(game.resultado())
        }
    }

    fun checkResult(result: Boolean) {
        if (result) {
            return messageDialog("¡Haz ganado! \nLa palabra secreta es: \n${game.getLetterSecret()}")
        }
        messageDialog("¡Haz ha perdido! \nLa palabra secreta era: \n${game.getLetterSecret()}")
    }

    fun messageDialog(message: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle(resources.getString(R.string.title))
            .setMessage(message)
            .setNegativeButton(resources.getString(R.string.salir)) { dialog, which ->
                finish()
            }
            .setPositiveButton(resources.getString(R.string.reintentar)) { dialog, which ->
                reloadGame()
            }
            .show()
    }

    fun changeText(text: String) {
        with(binding) {
            palabraSecreta.text = text
        }
    }

    fun addLetterOnClick(view: View) = btnPressList.add(view)

    fun changeStateButton() = btnPressList.forEach { it.isEnabled = true }

}