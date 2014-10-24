package com.xebia.innovationday.axonwebshop.api;

public class OrderCreatedEvent {
    private final String id;

    public OrderCreatedEvent(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return id;
    }

}
