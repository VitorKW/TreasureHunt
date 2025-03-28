package com.example.treasurehunt

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.treasurehunt.ui.theme.TelaCerta
import com.example.treasurehunt.ui.theme.TelaErrada
import com.example.treasurehunt.ui.theme.TelaInicial
import com.example.treasurehunt.ui.theme.TelaPista1
import com.example.treasurehunt.ui.theme.TelaPista2
import com.example.treasurehunt.ui.theme.TelaPista3
import com.example.treasurehunt.ui.theme.TelaResposta
import com.example.treasurehunt.ui.theme.TreasureHuntTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigationController = rememberNavController()
            NavHost(navController = navigationController, startDestination = "TelaInicial") {
                composable("TelaInicial") {
                    TelaInicial(
                        onNavigateToPista1 = { navigationController.navigate("TelaPista1") }
                    )
                }
                composable("TelaPista1") {
                    TelaPista1(
                        onNavigateToPista2 = { navigationController.navigate("TelaPista2") },
                        onNavigateToTelaInicial = { navigationController.navigate("TelaInicial") }
                    )
                }
                composable("TelaPista2") {
                    TelaPista2(
                        onNavigateToPista3 = { navigationController.navigate("TelaPista3") },
                        onNavigateToPista1 = { navigationController.navigate("TelaPista1") }
                    )
                }
                composable("TelaPista3") {
                    TelaPista3(
                        onNavigateToResposta = { navigationController.navigate("TelaResposta") },
                        onNavigateToPista2 = { navigationController.navigate("TelaPista2") }
                    )
                }
                composable("TelaResposta") {
                    TelaResposta(
                        onNavigateToCerta = { navigationController.navigate("TelaCerta") },
                        onNavigateToErrada = { navigationController.navigate("TelaErrada") }
                    )
                }
                composable("TelaCerta") {
                    TelaCerta(
                        onNavigateToTelaInicial = { navigationController.navigate("TelaInicial") },

                    )
                }
                composable("TelaErrada") {
                    TelaErrada(
                        onNavigateToTelaInicial = { navigationController.navigate("TelaInicial") },

                        )
                }
            }
        }
    }




    @Preview(showBackground = true)
    @Composable
    fun MyPreview() {
        TreasureHuntTheme {
            TelaInicial({})
        }
    }
}

