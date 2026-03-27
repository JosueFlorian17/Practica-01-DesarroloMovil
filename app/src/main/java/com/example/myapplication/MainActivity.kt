package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier=Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier=Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier=Modifier) {
    var mensaje by remember{mutableStateOf("Probando")}
    var fechaTexto by remember{mutableStateOf("11/22/2023")}

    Column(modifier=modifier.padding(16.dp)) {
        Text(text="Verificador de Año Bisiesto", modifier=Modifier.padding(bottom=8.dp))

        Button(
            onClick = {
                val fechaActual=LocalDate.now()
                val anio=fechaActual.year

                val bisiesto=(anio%4==0 && anio%100!=0) || (anio%400==0)

                mensaje=if (bisiesto) "Este año ($anio) es bisiesto" else "Este año ($anio) no es bisiesto"
                fechaTexto="Fecha actual: ${fechaActual}"
            }
        ) {
            Text(text="Verificador Bisiesto")
        }


        Text(text=mensaje, modifier=Modifier.padding(top=16.dp))
        Text(text=fechaTexto)
    }
}


/*
10. Crea una app que tenga un botón llamado “Verificador Bisiesto” y que imprima
si estamos en un año bisiesto y la fecha actual, con ello registra en un
documento: (7 puntos)
a. Link de git (público):
b. Capturas de pantalla del código:
c. Capturas de pantalla del funcionamiento:

 */




