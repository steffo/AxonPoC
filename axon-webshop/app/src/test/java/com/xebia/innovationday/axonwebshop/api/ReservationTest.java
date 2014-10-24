package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.domain.AggregateIdentifierNotInitializedException;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

public class ReservationTest {

    private static final String RESERVATION_ID = "randomId";
    private FixtureConfiguration fixture;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(Order.class);
    }

    @Test
    public void testReserveSeat() {
        fixture.given()
                .when(new ReserveSeatCommand(RESERVATION_ID))
                .expectEvents(new SeatReservedEvent(RESERVATION_ID));

    }

    @Test
    public void testCreateReservationWithNullId() {

        fixture.given()
                .when(new ReserveSeatCommand(null))
                .expectException(AggregateIdentifierNotInitializedException.class);
    }


}