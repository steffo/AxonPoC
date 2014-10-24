package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.domain.AggregateIdentifierNotInitializedException;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

public class BookingTest {

    private static final String BOOKING_ID = "randomBookingId";
    private static final String FLIGHT_ID = "someFlightId";
    private FixtureConfiguration fixture;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(Booking.class);
    }

    @Test
    public void testCreateOrder() {
        fixture.given()
            .when(new BookFlightCommand(BOOKING_ID, FLIGHT_ID))
            .expectEvents(new BookingRequestedEvent(BOOKING_ID, FLIGHT_ID));

    }

    @Test
    public void testCreateOrderWithNullId() {

        fixture.given()
            .when(new BookFlightCommand(null, null))
                .expectException(AggregateIdentifierNotInitializedException.class);
    }


}
