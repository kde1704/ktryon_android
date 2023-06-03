package com.example.ktryon.Client

import android.content.Context
import androidx.navigation.NavHostController
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.Volley

fun SendLoginToServer(
    context: Context,
    onValidLogin: (String) -> Unit,
    onInvalidLogin: (VolleyError) -> Unit
) {
    val requestQueue = Volley.newRequestQueue(context)

    val request = AuthedRequest(
        Request.Method.GET,
        "$host/check-login",
        onValidLogin,
        onInvalidLogin
    )

    requestQueue.add(request)
}

fun SendNewAccountToServer(
    context: Context,
    onValidAccount: (String) -> Unit,
    onInvalidAccount: (VolleyError) -> Unit
) {
    val requestQueue = Volley.newRequestQueue(context)

    val request = object : AuthedRequest(
        Method.POST,
        "$host/create-user",
        onValidAccount,
        onInvalidAccount
    ) {
        override fun getParams(): MutableMap<String, String>? {
            val body: MutableMap<String, String> = mutableMapOf()
            body.put("username", username)
            body.put("password", password)
            return body
        }
    }

    requestQueue.add(request)
}