package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

public class Flight extends AbstractAnnotatedAggregateRoot<Flight> {
    @AggregateIdentifier
    String id;

    Flight() {
    }

    @CommandHandler
    public Flight(ReserveSeatCommand command) {
        apply(new SeatReservedEvent(command.getReservationId()));
    }

    @EventHandler
    public void on(SeatReservedEvent event) {
        id = event.getReservationId();
    }


}
