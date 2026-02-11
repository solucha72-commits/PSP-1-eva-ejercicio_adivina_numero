package com.example.myapplication

data class Estado_juego(
    val mensaje: String = "Introduce un número del 1 al 100",
    val numeroUsuario: String = "",
    val juegoTerminado: Boolean = false
)