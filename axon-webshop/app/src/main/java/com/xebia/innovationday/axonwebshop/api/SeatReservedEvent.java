package com.xebia.innovationday.axonwebshop.api;

public class SeatReservedEvent {
    private final String flightId;
    private final String bookingId;

    public SeatReservedEvent(String flightId, String bookingId) {
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
