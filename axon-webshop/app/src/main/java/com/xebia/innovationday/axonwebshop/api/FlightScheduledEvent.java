package com.xebia.innovationday.axonwebshop.api;

public class FlightScheduledEvent {
    private final String flightId;

    public FlightScheduledEvent(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightId() {
        return flightId;
    }

}
