package com.abedsully.IShowShop.service.order;

import com.abedsully.IShowShop.dto.OrderDto;
import com.abedsully.IShowShop.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);
}
