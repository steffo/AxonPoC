package com.xebia.innovationday.axonwebshop.api;

public class CreateOrderCommand {

    private final String orderId;

    public CreateOrderCommand(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

}
