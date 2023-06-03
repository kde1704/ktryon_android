package com.example.ktryon.Client

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.ktryon.GlobalModel.ShopItem
import com.google.gson.Gson

private data class UnparsedShopItem(
    val name: String,
    val url: String,
    val price: Float,
    val id: Int,
    val tags: String
)

fun requestShopItems(
    o_json: String? = null,
    context: Context? = null,
    after: (List<ShopItem>) -> Unit
) {
    if (o_json != null) {
        val unparsed = getShopItemsAsList(o_json)
        val parsed = unparsed.map { parseUnparsedShopItems(it) }

        after(parsed)
        return
    }

    if (context != null) {
        requestShopItemsJson(context) { json ->
            val unparsed = getShopItemsAsList(json)
            val parsed = unparsed.map { parseUnparsedShopItems(it) }

            after(parsed)
        }
    }
}

private fun requestShopItemsJson(context: Context, after: (String) -> Unit) {
    val requestQueue = Volley.newRequestQueue(context)
    val request = AuthedRequest(
        Request.Method.GET,
        "$host/recommend",
        { response ->
            after(response)
        },
        {
            Log.e("REQUEST@ITEMS_CLIENT", "Error requesting from /recommend")
        }
    )

    requestQueue.add(request)
}

private fun parseUnparsedShopItems(item: UnparsedShopItem): ShopItem {
    val parsed_price = String.format("$%.2f", item.price)
    val parsed_tags = item.tags.split(",")
    val parsed_url = "$host/images/${item.url}.jpg"

    return ShopItem(item.name, parsed_url, parsed_price, parsed_tags, item.id)
}

private fun getShopItemsAsList(json_string: String): List<UnparsedShopItem> {
    // mutate items
    val gson = Gson()
    val list: Array<UnparsedShopItem> =
        gson.fromJson(json_string, Array<UnparsedShopItem>::class.java)


    return list.toList()
}
