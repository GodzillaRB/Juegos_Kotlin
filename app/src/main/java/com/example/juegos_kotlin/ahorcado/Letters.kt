package com.example.juegos_kotlin.ahorcado

import java.util.*

class Letters {

    private val list = listOf<String>(
        "Instito Tecnologico del Valle de Oaxaca",
        "Jorge Benito",
        "Clemente Eduardo",
        "League of Legends",
        "Katarina",
        "Zed",
        "Darius",
        "Gato",
        "Kotlin",
        "Parangaricutimicuaro"
    )

    fun getLettersRandom(): String {
        return list.random()
    }
}