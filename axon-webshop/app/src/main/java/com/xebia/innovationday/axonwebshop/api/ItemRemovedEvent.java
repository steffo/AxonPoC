package com.xebia.innovationday.axonwebshop.api;

public class ItemRemovedEvent {
    private final String cartId;
    private final String item;

    public ItemRemovedEvent(String cartId, String item) {
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
