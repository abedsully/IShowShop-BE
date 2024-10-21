package com.abedsully.IShowShop.service.order;

import com.abedsully.IShowShop.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    Order getOrder(Long orderId);
    List<Order> getUserOrders(Long userId);
}
