package com.example.ktryon.LoginScreen.Controller

import android.content.Context
import androidx.navigation.NavHostController
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.ktryon.Client.AuthedRequest
import com.example.ktryon.Client.SendLoginToServer
import com.example.ktryon.Client.SendNewAccountToServer
import com.example.ktryon.Client.host

fun ValidateLogin(
    username: String,
    password: String,
    navController: NavHostController,
    context: Context,
    onInvalidLogin: () -> Unit
) {
    AuthedRequest.username = username
    AuthedRequest.password = password

    SendLoginToServer(
        context = context,
        onValidLogin = {
            navController.navigate("Catalogue") {
                popUpTo(0)
            }
        },
        onInvalidLogin = { onInvalidLogin() }
    )

}

fun CreateAccount(
    username: String,
    password: String,
    navController: NavHostController,
    context: Context,
    onInvalidAccount: () -> Unit
) {
    AuthedRequest.username = username
    AuthedRequest.password = password

    SendNewAccountToServer(
        context = context,
        onValidAccount = {
            navController.navigate("Catalogue") {
                popUpTo(0)
            }
        },
        onInvalidAccount = { onInvalidAccount() }
    )

}