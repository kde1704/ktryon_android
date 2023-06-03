package com.example.ktryon.Client

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.Volley

fun postCheckoutToServer(name: String, size: String, address: String, context: Context, after: (String) -> Unit) {
    val requestQueue = Volley.newRequestQueue(context)

    val request = object : AuthedRequest(
        Method.POST,
        "$host/payment",
        { response ->
            after(response)
        },
        {
            Log.e("REQUEST@ITEMS_CLIENT", "Error requesting from /recommend")
            after("")
        }
    ) {
        override fun getParams(): MutableMap<String, String>? {
            val old: MutableMap<String, String> = mutableMapOf()
            old.put("item", name)
            old.put("size", size)
            old.put("address", address)
            return old
        }
    }

    requestQueue.add(request)
}