package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class ReserveSeatCommand {

    @TargetAggregateIdentifier
    private final String flightId;

    private final String bookingId;

    public ReserveSeatCommand(String flightId, String bookingId) {
        this.flightId = flightId;
        this.bookingId = bookingId;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getBookingId() {
        return bookingId;
    }

}
