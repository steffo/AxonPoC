package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.test.saga.AnnotatedSagaTestFixture;
import org.junit.Before;
import org.junit.Test;

public class OrderSagaTest {

    private AnnotatedSagaTestFixture fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new AnnotatedSagaTestFixture(OrderSaga.class);
    }

    @Test
    public void testOnOrderCreated() {
        String orderId = "someOrderId";
        fixture.whenAggregate(orderId).publishes(new OrderCreatedEvent(orderId)).
            expectDispatchedCommandsEqualTo(new ReserveSeatCommand()).
            expectActiveSagas(1).
            expectAssociationWith("orderId", orderId);
    }

}
