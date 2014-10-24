package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

public class Booking extends AbstractAnnotatedAggregateRoot<Booking> {
    @AggregateIdentifier
    String id;

    Booking() {
    }

    @CommandHandler
    public Booking(BookFlightCommand command) {
        apply(new BookingRequestedEvent(command.getBookingId(), command.getFlightId()));
    }

    @EventHandler
    public void on(BookingRequestedEvent event) {
        id = event.getBookingId();
    }


}
