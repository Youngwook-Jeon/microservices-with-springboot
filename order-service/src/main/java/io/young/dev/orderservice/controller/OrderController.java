package io.young.dev.orderservice.controller;

import io.young.dev.orderservice.dto.OrderDto;
import io.young.dev.orderservice.jpa.OrderEntity;
import io.young.dev.orderservice.service.OrderService;
import io.young.dev.orderservice.vo.RequestOrder;
import io.young.dev.orderservice.vo.ResponseOrder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order-service")
@RequiredArgsConstructor
public class OrderController {

    Environment env;
    OrderService orderService;

    @GetMapping("/health_check")
    public String status() {
        return String.format("It is working in order service on port: %s",
                env.getProperty("local.server.port"));
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<ResponseOrder> createOrder(
            @PathVariable("userId") String userId,
            @RequestBody RequestOrder orderDetails) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        OrderDto orderDto = mapper.map(orderDetails, OrderDto.class);
        orderDto.setUserId(userId);

        OrderDto createdOrder = orderService.createOrder(orderDto);

        ResponseOrder responseOrder = mapper.map(createdOrder, ResponseOrder.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseOrder);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrder(@PathVariable("userId") String userId) {
        Iterable<OrderEntity> orders = orderService.getOrdersByUserId(userId);
        List<ResponseOrder> result = new ArrayList<>();
        orders.forEach(o -> result.add(new ModelMapper().map(o, ResponseOrder.class)));

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
