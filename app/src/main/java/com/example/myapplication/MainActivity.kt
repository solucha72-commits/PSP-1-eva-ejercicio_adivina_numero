package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
          pantallaJuego()
        }
    }
}

@Composable
private fun pantallaJuego(miviewModel: GameViewModel=viewModel()) {
    val estado=miviewModel.estado
    Column(modifier = Modifier.padding(20.dp)) {
        Spacer(modifier = Modifier.height(100.dp))
        // 1. El mensaje (pistas mayor/menor)
        Text(text = estado.mensaje)


        // 2. Cuadro para escribir
        TextField(
            value = estado.numeroUsuario,
            onValueChange = { miviewModel.numero_nuevo(it) },
            label = { Text("Escribe un número") }
        )



        // 3. Botón para jugar
        Button(onClick = { miviewModel.comprobar_numero() }) {
            Text("¿He acertado?")
        }}
}


