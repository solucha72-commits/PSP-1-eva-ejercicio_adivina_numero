package com.example.myapplication

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GameViewModelTest {

    private lateinit var viewModel: GameViewModel

    @Before
    fun setup() {
        viewModel = GameViewModel(numeroInicial = 50)
    }

    @Test
    fun numeroMenor_muestraMensajeMayor() {
        viewModel.numero_nuevo("20")
        viewModel.comprobar_numero()

        assertTrue(viewModel.estado.mensaje.contains("mayor"))
    }

    @Test
    fun numeroMayor_muestraMensajeMenor() {
        viewModel.numero_nuevo("80")
        viewModel.comprobar_numero()

        assertTrue(viewModel.estado.mensaje.contains("menor"))
    }

    @Test
    fun numeroCorrecto_terminaJuego() {
        viewModel.numero_nuevo("50")
        viewModel.comprobar_numero()

        assertEquals("¡HAS ACERTADO!", viewModel.estado.mensaje)
        assertTrue(viewModel.estado.juegoTerminado)
    }

    @Test
    fun numeroInvalido_muestraError() {
        viewModel.numero_nuevo("abc")
        viewModel.comprobar_numero()

        assertEquals("Escribe un número válido", viewModel.estado.mensaje)
    }
}