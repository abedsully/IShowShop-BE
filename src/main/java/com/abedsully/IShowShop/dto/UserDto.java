package com.abedsully.IShowShop.dto;

import com.abedsully.IShowShop.model.Cart;
import com.abedsully.IShowShop.model.Order;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<OrderDto> orders;
    private CartDto cart;
}
