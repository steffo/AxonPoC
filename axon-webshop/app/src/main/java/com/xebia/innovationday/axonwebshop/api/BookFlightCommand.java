package com.xebia.innovationday.axonwebshop.api;

public class BookFlightCommand {

    private final String bookingId;
    private final String flightId;

    public BookFlightCommand(String bookingId, String flightId) {
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
