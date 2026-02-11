package com.example.myapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameViewModel : ViewModel() {
    private var numeroSecreto = Random.nextInt(1, 101)

    var estado by mutableStateOf(Estado_juego())
        private set

    fun numero_nuevo(nuevoValor: String) {
        estado = estado.copy(numeroUsuario = nuevoValor)
    }

    fun comprobar_numero() {
        val nUsuario = estado.numeroUsuario.toIntOrNull()

        // Si no es un número, avisamos y cortamos aquí (return)
        if (nUsuario == null) {
            estado = estado.copy(mensaje = "Escribe un número válido")
            return
        }

        // IMPORTANTE: Ponemos "estado =" antes de cada .copy()
        if (nUsuario > numeroSecreto) {
            estado = estado.copy(mensaje = "El número secreto es menor ↓", numeroUsuario = "")
        } else if (nUsuario < numeroSecreto) {
            estado = estado.copy(mensaje = "El número secreto es mayor ↑", numeroUsuario = "")
        } else {
            estado = estado.copy(mensaje = "¡HAS ACERTADO!", juegoTerminado = true)
        }
    }
}