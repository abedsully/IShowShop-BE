package com.abedsully.IShowShop.exceptions;

import com.abedsully.IShowShop.model.Product;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
