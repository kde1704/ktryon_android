package com.example.ktryon.Client

import android.content.Context
import android.graphics.Bitmap
import android.widget.Toast
import androidx.compose.runtime.Composable
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import java.io.ByteArrayOutputStream


private fun getFileDataFromDrawable(bitmap: Bitmap): ByteArray {
    val byteArrayOutputStream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream)
    return byteArrayOutputStream.toByteArray()
}

// TODO: POST BITMAP AND NAME INFO (name IS CLOTHING ITEM NAME)
fun PostTryOnBitmap(bitmap: Bitmap, name: String, context: Context) {
    //our custom volley request
    val volleyMultipartRequest: VolleyMultipartRequest =
        object : VolleyMultipartRequest(
            Request.Method.POST, "$host/viton",
            { response ->
                print("success!!!!!!!!!")
            },
            {}) {

            /*
            * Here we are passing image by renaming it with a unique name
            * */

            override fun getParams(): MutableMap<String, String> {
                val body: MutableMap<String, String> = mutableMapOf()
                body.put("name", name)
                body.put("X-Username", AuthedRequest.username)
                body.put("X-Username", AuthedRequest.username)
                return body
            }

            override val byteData: Map<String, DataPart>
                get() {
                    val params: MutableMap<String, DataPart> = HashMap()
                    params["file"] = DataPart("file", getFileDataFromDrawable(bitmap))
                    return params
                }
        }

    //adding the request to volley

    //adding the request to volley
    Volley.newRequestQueue(context).add(volleyMultipartRequest)
}

