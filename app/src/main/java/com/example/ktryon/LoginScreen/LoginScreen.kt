package com.example.ktryon.LoginScreen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ktryon.Client.AuthedRequest
import com.example.ktryon.LoginScreen.Controller.ValidateLogin
import com.example.ktryon.ui.theme.KtryonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController? = null,
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(54.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            "Login",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(Modifier.height(96.dp))

        Column {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Username") },
                value = username,
                onValueChange = { username = it },
                maxLines = 1,
                isError = isError,
            )

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Password") },
                value = password,
                onValueChange = { password = it },
                maxLines = 1,
                visualTransformation = PasswordVisualTransformation(),
                isError = isError,
            )

            Spacer(Modifier.height(8.dp))

            val context = LocalContext.current

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    if (username.isNotBlank() && password.isNotBlank() && navController != null) {
                        ValidateLogin(
                            username,
                            password,
                            navController,
                            context
                        ) {
                            isError = true
                            password = ""
                        }
                    }
                }
            ) {
                Text(
                    "Submit",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LoginScreenPreview() {
    KtryonTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            LoginScreen()
        }
    }
}