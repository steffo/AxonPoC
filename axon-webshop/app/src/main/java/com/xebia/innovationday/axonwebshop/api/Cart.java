package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

public class Cart extends AbstractAnnotatedAggregateRoot<Cart> {

    @AggregateIdentifier
    private String id;

    Cart() {
    }

    public Cart(AddItemCommand command) {
        apply(new CartCreatedEvent(command.getCartId()));
        handle(command);
    }

    public void handle(AddItemCommand command) {
        apply(new ItemAddedEvent(command.getCartId(), command.getItem()));
    }

    @EventHandler
    public void on(CartCreatedEvent event) {
        id = event.getCartId();
    }

}
