package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class CancelBookingCommand {

    @TargetAggregateIdentifier
    private final String bookingId;

    public CancelBookingCommand(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingId() {
        return bookingId;
    }
}
