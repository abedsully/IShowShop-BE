package com.abedsully.IShowShop.service.cart;

import com.abedsully.IShowShop.model.Cart;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCartById(Long id);
    void clearClart(Long id);
    BigDecimal getTotalPrice(Long id);
}
