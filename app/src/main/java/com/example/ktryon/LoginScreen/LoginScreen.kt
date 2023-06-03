package com.example.ktryon.LoginScreen

import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ktryon.Client.AuthedRequest
import com.example.ktryon.LoginScreen.Controller.CreateAccount
import com.example.ktryon.LoginScreen.Controller.ValidateLogin
import com.example.ktryon.ui.theme.KtryonTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun LoginScreen(
    navController: NavHostController? = null,
) {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    var isError by rememberSaveable { mutableStateOf(false) }

    var isLogin by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(54.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        AnimatedContent(targetState = isLogin) { isLogin ->
            Text(
                if (isLogin) "Login" else "Create Account",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        }


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

            Spacer(Modifier.height(16.dp))

            val context = LocalContext.current

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    if (username.isNotBlank() && password.isNotBlank() && navController != null) {
                        if (isLogin) {
                            ValidateLogin(
                                username = username,
                                password = password,
                                navController = navController,
                                context = context
                            ) {
                                isError = true
                                password = ""
                            }
                        } else {
                            CreateAccount(
                                username = username,
                                password = password,
                                navController = navController,
                                context = context
                            ) {
                                isError = true
                                password = ""
                                username = ""
                            }
                        }
                    }
                }
            ) {

                AnimatedContent(targetState = isLogin) { isLogin ->
                    Text(
                        text = if (isLogin) "Login" else "Create",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            AnimatedContent(targetState = isLogin) { isLoginTarget ->
                Text(
                    modifier = Modifier.clickable { isLogin = !isLogin },
                    text = if (isLoginTarget) "Don't have an account? Create one." else "Already have an account? Login.",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
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