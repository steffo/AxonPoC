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
    public Flight(ScheduleFlightCommand command) {
        apply(new FlightScheduledEvent(command.getFlightId()));
    }

    @EventHandler
    public void on(FlightScheduledEvent event) {
        id = event.getFlightId();
    }


}
