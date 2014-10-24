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
        fixture = Fixtures.newGivenWhenThenFixture(Flight.class);
    }

    @Test
    public void testScheduleFlight() {
        fixture.given()
            .when(new ScheduleFlightCommand(FLIGHT_ID))
            .expectEvents(new FlightScheduledEvent(FLIGHT_ID));

    }

    @Test
    public void testScheduleFlightWithNullId() {

        fixture.given()
            .when(new ScheduleFlightCommand(null))
                .expectException(AggregateIdentifierNotInitializedException.class);
    }


}
