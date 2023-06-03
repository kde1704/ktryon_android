package com.example.ktryon.LoginScreen.Controller

import android.content.Context
import androidx.navigation.NavHostController
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.ktryon.Client.AuthedRequest
import com.example.ktryon.Client.host

fun ValidateLogin(username: String, password: String, navController: NavHostController, context: Context, onInvalidLogin: () -> Unit) {
    val requestQueue = Volley.newRequestQueue(context)
    AuthedRequest.username = username
    AuthedRequest.password = password
    val request = AuthedRequest(
        Request.Method.GET,
        "http://10.0.2.2:8933/check-login",
        { response ->
            navController.navigate("Catalogue") {
                popUpTo(0)
            }
        },
        {
            onInvalidLogin()
        }
    )

    requestQueue.add(request)
}