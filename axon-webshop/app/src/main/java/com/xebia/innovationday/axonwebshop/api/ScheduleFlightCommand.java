package com.xebia.innovationday.axonwebshop.api;

public class ScheduleFlightCommand {

    private final String flightId;

    public ScheduleFlightCommand(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightId() {
        return flightId;
    }
}
