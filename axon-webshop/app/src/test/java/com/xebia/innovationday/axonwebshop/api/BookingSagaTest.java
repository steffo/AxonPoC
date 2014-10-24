package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.test.matchers.Matchers;
import org.axonframework.test.saga.AnnotatedSagaTestFixture;
import org.joda.time.Duration;
import org.junit.Before;
import org.junit.Test;

import com.xebia.innovationday.matchers.CommandTypeMatcher;

public class BookingSagaTest {

    private AnnotatedSagaTestFixture fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new AnnotatedSagaTestFixture(BookingSaga.class);
    }

    @Test
    public void testOnBookingRequested() {
        String bookingId = "someBookingId";
        String flightId = "someFlightId";
        fixture.whenAggregate(bookingId).publishes(new BookingRequestedEvent(bookingId, flightId)).
            expectDispatchedCommandsMatching(Matchers.exactSequenceOf(new CommandTypeMatcher(ReserveSeatCommand.class))).
            expectActiveSagas(1).
            expectAssociationWith("bookingId", bookingId).
            expectPublishedEvents(new HurrayEvent());
    }

    @Test
    public void testOnSeatReserved() {
        String bookingId = "someBookingId";
        String flightId = "someFlightId";
        fixture.givenAggregate(bookingId).published(new BookingRequestedEvent(bookingId, flightId))
            .whenAggregate(flightId).publishes(new SeatReservedEvent(flightId, bookingId))
            .expectDispatchedCommandsEqualTo(new CompleteBookingCommand(bookingId))
            .expectActiveSagas(0);
        ;
    }

    @Test
    public void testOnSeatReservedWithMultipleActiveSagas() {
        String bookingId = "someBookingId";
        String flightId = "someFlightId";
        fixture.givenAggregate(bookingId).published(new BookingRequestedEvent(bookingId, flightId))
            .andThenAggregate("otherBookingId").published(new BookingRequestedEvent("otherBookingId", flightId))
            .andThenAggregate("otherBookingId2").published(new BookingRequestedEvent("otherBookingId2", flightId))
            .whenAggregate(flightId).publishes(new SeatReservedEvent(flightId, bookingId))
            .expectDispatchedCommandsEqualTo(new CompleteBookingCommand(bookingId))
            .expectActiveSagas(2);
        ;
    }

    @Test
    public void testSeatReservationTimedOut() {
        String bookingId = "someBookingId";
        String flightId = "someFlightId";
        fixture.givenAggregate(bookingId).published(new BookingRequestedEvent(bookingId, flightId))
            .whenTimeElapses(Duration.millis(2000))
            .expectDispatchedCommandsEqualTo(new CancelBookingCommand(bookingId))
            .expectActiveSagas(0);
        ;
    }

}
