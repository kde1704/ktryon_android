package com.example.ktryon.Client

import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest

open class AuthedRequest (
    method: Int, url: String,
    listener: (response: String) -> Unit,
    errorListener: (error: VolleyError) -> Unit,
) : StringRequest(method, url, listener, errorListener) {
    companion object {
        var username = ""
        var password = ""
    }

    override fun getHeaders(): MutableMap<String, String> {
        val old = super.getHeaders()
        val new = HashMap<String, String>()

        for ((key, value) in old) {
            new[key] = value
        }

        new["X-Username"] = username
        new["X-Password"] = password

        return new
    }
}