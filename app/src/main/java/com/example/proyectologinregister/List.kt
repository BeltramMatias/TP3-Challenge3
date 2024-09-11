package com.example.proyectologinregister

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectologinregister.ui.theme.ProyectoLoginRegisterTheme

class ItemListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoLoginRegisterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ItemListView(modifier = Modifier.padding(innerPadding)) // Renombramos la función a "ItemListView"
                }
            }
        }
    }
}

@Composable
fun ItemListView(modifier: Modifier = Modifier) {  // Cambiamos el nombre a "ItemListView"
    // Lista mutable de items que empieza vacía
    var items by remember { mutableStateOf(listOf<String>()) }
    var textFieldValue by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        // Campo de texto para ingresar el nuevo item
        TextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            label = { Text("Ingrese un elemento") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Botón para agregar el elemento a la lista
        Button(
            onClick = {
                if (textFieldValue.isNotEmpty()) {
                    // Agrega el valor del campo de texto a la lista de items
                    items = items + textFieldValue
                    textFieldValue = "" // Limpia el campo de texto después de agregar
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // LazyColumn para mostrar los items agregados
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items) { item ->
                Text(
                    text = item,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemListViewPreview() {
    ProyectoLoginRegisterTheme {
        ItemListView()  // Actualizamos también el nombre aquí
    }
}
