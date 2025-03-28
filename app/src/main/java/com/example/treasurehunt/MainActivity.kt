package com.example.treasurehunt

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.treasurehunt.ui.theme.TelaCerta
import com.example.treasurehunt.ui.theme.TelaErrada
import com.example.treasurehunt.ui.theme.TelaInicial
import com.example.treasurehunt.ui.theme.TelaPista1
import com.example.treasurehunt.ui.theme.TelaPista2
import com.example.treasurehunt.ui.theme.TelaPista3
import com.example.treasurehunt.ui.theme.TelaResposta
import com.example.treasurehunt.ui.theme.TreasureHuntTheme
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable



class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigationController = rememberNavController()
            AnimatedNavHost(navController = navigationController, startDestination = "TelaInicial",
                enterTransition = { fadeIn(animationSpec = tween(700)) },
                exitTransition = { fadeOut(animationSpec = tween(700)) })
            {
                composable("TelaInicial",
                    enterTransition = { slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(500)) },
                    exitTransition = { slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(500)) }
                ) {
                    TelaInicial(
                        onNavigateToPista1 = { navigationController.navigate("TelaPista1") }
                    )
                }
                composable("TelaPista1",
                    enterTransition = { slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(500)) },
                    exitTransition = { slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(500)) }
                ) {
                    TelaPista1(
                        onNavigateToPista2 = { navigationController.navigate("TelaPista2") },
                        onNavigateToTelaInicial = { navigationController.navigate("TelaInicial") }
                    )
                }
                composable("TelaPista2",
                    enterTransition = { slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(500)) },
                    exitTransition = { slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(500)) }
                ) {
                    TelaPista2(
                        onNavigateToPista3 = { navigationController.navigate("TelaPista3") },
                        onNavigateToPista1 = { navigationController.navigate("TelaPista1") }
                    )
                }
                composable("TelaPista3",
                    enterTransition = { slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(500)) },
                    exitTransition = { slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(500)) }
                ) {
                    TelaPista3(
                        onNavigateToResposta = { navigationController.navigate("TelaResposta") },
                        onNavigateToPista2 = { navigationController.navigate("TelaPista2") }
                    )
                }
                composable("TelaResposta",
                    enterTransition = { fadeIn(animationSpec = tween(700)) },
                    exitTransition = { fadeOut(animationSpec = tween(700)) }
                ) {
                    TelaResposta(
                        onNavigateToTelaCerta = { navigationController.navigate("TelaCerta") },
                        onNavigateToTelaErrada = { navigationController.navigate("TelaErrada") }
                    )
                }
                composable("TelaCerta",
                    enterTransition = { fadeIn(animationSpec = tween(700)) },
                    exitTransition = { fadeOut(animationSpec = tween(700)) }
                )
                {
                    TelaCerta(
                        onNavigateToTelaInicial = { navigationController.navigate("TelaInicial") },

                    )
                }
                composable("TelaErrada",
                    enterTransition = { fadeIn(animationSpec = tween(700)) },
                    exitTransition = { fadeOut(animationSpec = tween(700)) }
                ) {
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

