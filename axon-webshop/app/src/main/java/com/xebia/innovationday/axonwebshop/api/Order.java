package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

public class Order extends AbstractAnnotatedAggregateRoot<Order> {
    @AggregateIdentifier
    String id;

    Order() {
    }

    @CommandHandler
    public Order(CreateOrderCommand command) {
        apply(new OrderCreatedEvent(command.getOrderId()));
    }

    @EventHandler
    public void on(OrderCreatedEvent event) {
        id = event.getOrderId();
    }


}
