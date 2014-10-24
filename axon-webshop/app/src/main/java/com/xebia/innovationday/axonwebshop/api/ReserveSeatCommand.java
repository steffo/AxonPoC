package com.xebia.innovationday.axonwebshop.api;

public class ReserveSeatCommand {


    private final String reservationId;

    public ReserveSeatCommand(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getReservationId() {
        return reservationId;
    }

}
