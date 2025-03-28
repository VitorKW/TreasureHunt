package com.example.treasurehunt.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.treasurehunt.R


@Composable
fun TelaInicial(onNavigateToPista1: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Caça ao Tesouro",
            fontSize = 40.sp)
        Button(
            onClick = { onNavigateToPista1() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Começar!", fontSize = 34.sp,
                textAlign = TextAlign.Center)
        }


    }
}

@Composable
fun TelaPista1(onNavigateToPista2: () -> Unit, onNavigateToTelaInicial: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Primeira Charada", fontSize = 36.sp, fontFamily = FontFamily.Serif)

        Button(
            onClick = { onNavigateToPista2() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Próxima Pista")
        }

        Button(
            onClick = { onNavigateToTelaInicial() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Voltar")
        }

        Row {
            Text(
                text = "Pista 1: Sou essencial para a vida, mas posso afogar você.",
                fontSize = 24.sp,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Composable
fun TelaPista2(onNavigateToPista3: () -> Unit, onNavigateToPista1: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Segunda Charada", fontSize = 36.sp, fontFamily = FontFamily.Serif)
        Button(
            onClick = { onNavigateToPista3() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Próxima Pista")
        }
        Button(
            onClick = { onNavigateToPista1() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Voltar")


        }
        Row {
            Text(
                text = "Pista 2: Posso estar no estado sólido, líquido ou gasoso.",
                fontSize = 24.sp,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun TelaPista3(onNavigateToResposta: () -> Unit, onNavigateToPista2: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Terceira Charada", fontSize = 36.sp, fontFamily = FontFamily.Serif)
        Button(
            onClick = { onNavigateToResposta() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Responder")
        }
        Button(
            onClick = { onNavigateToPista2() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Voltar")
        }
        Row {
            Text(
                text = "Pista 3: Sem mim, os oceanos não existiriam.",
                fontSize = 24.sp,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun TelaResposta(onNavigateToTelaCerta: () -> Unit, onNavigateToTelaErrada: () -> Unit) {
    var resposta by remember { mutableStateOf("") }
    val respostaCorreta = "Agua"

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Resposta para a Charada",
            fontSize = 36.sp,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center)

        OutlinedTextField(
            value = resposta,
            onValueChange = { resposta = it },
            label = { Text("Digite a resposta") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Button(
            onClick = {
                if (resposta.equals(respostaCorreta, ignoreCase = true)) {
                    onNavigateToTelaCerta()
                } else {
                    onNavigateToTelaErrada()
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Confirmar")
        }
    }
}

@Composable
fun TelaCerta(onNavigateToTelaInicial: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "RESPOSTA CORRETA!", fontSize = 36.sp, fontFamily = FontFamily.Serif)


        Image(
            painter = painterResource(id = R.drawable.tesouro),
            contentDescription = "Imagem de Tesouro"
        )

        Text(
            text = "Meus Parabéns, Você Conseguiu!",
            fontSize = 24.sp,
            fontFamily = FontFamily.Serif
        )

        Button(
            onClick = onNavigateToTelaInicial,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Voltar à Tela Inicial")
        }
    }
}

@Composable
fun TelaErrada(onNavigateToTelaInicial: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "RESPOSTA ERRADA!", fontSize = 36.sp, fontFamily = FontFamily.Serif)


        Image(
            painter = painterResource(id = R.drawable.bomba),
            contentDescription = "Imagem de bomba"
        )

        Text(
            text = "Você Errou, lá vai bomba!",
            fontSize = 24.sp,
            fontFamily = FontFamily.Serif
        )

        Button(
            onClick = onNavigateToTelaInicial,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Voltar à Tela Inicial")
        }
    }
}
