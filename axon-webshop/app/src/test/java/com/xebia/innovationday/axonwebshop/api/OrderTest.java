package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {

    private static final String ORDER_ID = "randomOrderId";
    private FixtureConfiguration fixture;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(Order.class);
    }

    @Test
    public void testCreateOrder() {
        fixture.given()
            .when(new CreateOrderCommand(ORDER_ID))
            .expectEvents(new OrderCreatedEvent(ORDER_ID));

    }

}
