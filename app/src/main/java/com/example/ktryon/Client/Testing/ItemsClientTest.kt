package com.example.ktryon.Client.Testing

import com.example.ktryon.Client.requestShopItems

fun main() {
    val sample_request_json = """
        [ 
            {"name": "Skirt", "url": "40400", "price": 35.2, "id": 123, "tags": "Hello,Hi,Kill,Bye"},
            {"name": "Flak Jacket", "url": "40401", "price": 15.1, "id": 124, "tags": "Car,Jacked,Manly,Jacket"},
            {"name": "Pinker Skirt", "url": "40403", "price": 1000.03, "id": 125, "tags": "Hello,Hi,Kill,Bye"},
            {"name": "Real Suit", "url": "1803", "price": 32.1, "id": 126, "tags": "Suited,Jacked,Lead,Jacket"}
        ]
    """.trimIndent()

    println(sample_request_json)
    val shopItems = requestShopItems(sample_request_json) { shopItems ->
        println(shopItems)
    }
}