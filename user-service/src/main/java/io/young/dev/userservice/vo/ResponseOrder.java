package io.young.dev.userservice.vo;

import lombok.Data;

import java.time.Instant;

@Data
public class ResponseOrder {

    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private Instant createdAt;
    private String orderId;
}
