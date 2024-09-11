package com.example.proyectologinregister

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectologinregister.ui.theme.ProyectoLoginRegisterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoLoginRegisterTheme {
                // Creamos el NavController
                val navController = rememberNavController()

                // Envolvemos todo el contenido dentro de Scaffold
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    // Configuramos el NavHost con las pantallas
                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        modifier = Modifier.padding(innerPadding) // Agregamos el padding aquí
                    ) {
                        composable("login") {
                            // Pantalla de Login
                            LoginView(navController)
                        }
                        composable("item_list") {
                            // Pantalla de Lista de Items
                            LazyListView()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LoginView(navController: NavHostController, modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Campo de texto para el usuario
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para la contraseña
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation() // Ocultar el texto de la contraseña
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botón de inicio de sesión
        Button(
            onClick = {
                // Navega a la pantalla de lista de items
                navController.navigate("item_list")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }
    }
}

@Composable
fun LazyListView(modifier: Modifier = Modifier) {
    // Aquí puedes agregar la lógica de la lista
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Lista de Items")
        // Aquí puedes agregar la LazyColumn para la lista de items
    }
}


@Preview(showBackground = true)
@Composable
fun LoginViewPreview() {
    ProyectoLoginRegisterTheme {
        val navController = rememberNavController()
        LoginView(navController)
    }
}


