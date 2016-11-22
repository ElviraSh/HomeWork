package ru.kpfu.itis.ShalafaevaElvira.utils;

import java.util.HashMap;

/**
 * Created by Elvira on 12.11.2016.
 */
public class CartClass {
    HashMap<String, Integer> cartItems;

    public CartClass() {
        cartItems = new HashMap<>();
    }

    public HashMap getCartItems() {
        return cartItems;
    }

    public void addToCart(String itemId, int price) {
        cartItems.put(itemId, price);
    }

    public void deleteFromCart(String itemId) {
        cartItems.remove(itemId);
    }
}