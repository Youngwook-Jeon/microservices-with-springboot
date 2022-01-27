package io.young.dev.orderservice.service;

import io.young.dev.orderservice.dto.OrderDto;
import io.young.dev.orderservice.jpa.OrderEntity;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDetails);
    OrderDto getOrderByOrderId(String orderId);
    Iterable<OrderEntity> getOrdersByUserId(String userId);
}
