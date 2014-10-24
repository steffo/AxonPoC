package com.xebia.innovationday.axonwebshop.api;

public class BookingRequestedEvent {
    private final String bookingId;
    private final String flightId;

    public BookingRequestedEvent(String bookingId, String flightId) {
        this.bookingId = bookingId;
        this.flightId = flightId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getFlightId() {
        return flightId;
    }
}
