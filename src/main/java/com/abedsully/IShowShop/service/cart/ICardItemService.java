package com.abedsully.IShowShop.service.cart;

import com.abedsully.IShowShop.model.CartItem;

public interface ICardItemService {
    void addItemToCart(Long cartId, Long productId, int quantity);
    void removeItemFromCart(Long cartId, Long productId);
    void updateItemQuantity(Long cartId, Long productId, int quantity);
}
