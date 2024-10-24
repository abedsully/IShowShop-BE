package com.abedsully.IShowShop.dto;

import com.abedsully.IShowShop.model.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDto {
    private Long cartId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private ProductDto product;
}
