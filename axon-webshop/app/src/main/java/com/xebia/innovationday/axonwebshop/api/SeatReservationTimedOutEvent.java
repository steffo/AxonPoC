package com.xebia.innovationday.axonwebshop.api;

public class SeatReservationTimedOutEvent {

    private final String bookingId;

    public SeatReservationTimedOutEvent(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingId() {
        return bookingId;
    }
}
