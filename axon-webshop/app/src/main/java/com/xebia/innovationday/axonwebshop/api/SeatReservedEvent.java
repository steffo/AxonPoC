package com.xebia.innovationday.axonwebshop.api;

public class SeatReservedEvent {
    private final String reservationId;

    public SeatReservedEvent(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getReservationId() {
        return reservationId;
    }

}
