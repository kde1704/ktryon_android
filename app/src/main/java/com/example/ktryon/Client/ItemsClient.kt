package com.example.ktryon.Client

import com.example.ktryon.GlobalModel.ShopItem

val items: List<ShopItem> = List(16) {
    if (it % 3 != 0) {
        ShopItem(
            "Femboy Skirt",
            "$35.50",
            "https://kawaiibabe.com/cdn/shop/products/princess-pink-plaid-fur-lined-skirt-xs-bottoms-cosplay-fairy-kei-kawaii-lolita-skirts-ddlg-playground-363_800x.jpg?v=1612736252",
            listOf("Skirt", "Pink", "Ebullient", "Bubbly", "Oh")
        )
    } else {
        ShopItem(
            "Distinguished Tie",
            "$12.50",
            "https://i.kym-cdn.com/photos/images/newsfeed/002/343/546/d4f.jpg",
            listOf("Gentleman", "Man", "Tie", "Handsome", "Emoji")
        )
    }
}

fun requestItems() {
    // mutate items
}