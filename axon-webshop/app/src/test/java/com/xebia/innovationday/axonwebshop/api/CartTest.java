package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

public class CartTest {

    private static final String ITEM1 = "item1";
    private static final String CART_ID = "non-existent-id";
    private FixtureConfiguration fixture;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(Cart.class);
        AddItemCommandHandler createCartCommandHandler = new AddItemCommandHandler();
        createCartCommandHandler.setRepository(fixture.getRepository());
        fixture.registerAnnotatedCommandHandler(createCartCommandHandler);

    }

    @Test
    public void addItemToNewCart() {

        fixture.given()
            .when(new AddItemCommand(CART_ID, ITEM1))
            .expectEvents(new CartCreatedEvent(CART_ID), new ItemAddedEvent(CART_ID, ITEM1));
    }

    @Test
    public void addItemToExistingCart() {

        fixture.given(new CartCreatedEvent(CART_ID))
            .when(new AddItemCommand(CART_ID, ITEM1))
            .expectEvents(new ItemAddedEvent(CART_ID, ITEM1));
    }

    @Test
    public void removeItemFromCart() {
        fixture.given(new CartCreatedEvent(CART_ID), new ItemAddedEvent(CART_ID, ITEM1))
            .when(new RemoveItemCommand(CART_ID, ITEM1))
            .expectEvents(new ItemRemovedEvent(CART_ID, ITEM1));
    }


}
