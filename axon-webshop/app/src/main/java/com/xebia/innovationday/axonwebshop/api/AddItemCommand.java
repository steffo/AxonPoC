package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class AddItemCommand {
    @TargetAggregateIdentifier
    private final String cartId;
    private final String item;

    public AddItemCommand(String cartId, String item) {
        this.cartId = cartId;
        this.item = item;
    }

    public String getCartId() {
        return cartId;
    }

    public String getItem() {
        return item;
    }
}
