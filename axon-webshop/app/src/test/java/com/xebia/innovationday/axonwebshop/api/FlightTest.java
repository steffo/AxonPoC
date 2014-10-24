package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.domain.AggregateIdentifierNotInitializedException;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

public class FlightTest {

    private static final String FLIGHT_ID = "randomId";
    private FixtureConfiguration fixture;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(Booking.class);
    }

    @Test
    public void testReserveSeat() {
        fixture.given()
                .when(new ReserveSeatCommand(FLIGHT_ID))
                .expectEvents(new SeatReservedEvent(FLIGHT_ID));

    }

    @Test
    public void testCreateReservationWithNullId() {

        fixture.given()
                .when(new ReserveSeatCommand(null))
                .expectException(AggregateIdentifierNotInitializedException.class);
    }


}
