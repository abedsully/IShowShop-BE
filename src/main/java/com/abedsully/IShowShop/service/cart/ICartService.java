package com.abedsully.IShowShop.service.cart;

import com.abedsully.IShowShop.model.Cart;
import com.abedsully.IShowShop.model.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCartById(Long id);
    void clearClart(Long id);
    BigDecimal getTotalPrice(Long id);

    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long id);
}
