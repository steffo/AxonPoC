package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class CompleteBookingCommand {

    @TargetAggregateIdentifier
    private final String bookingId;

    public CompleteBookingCommand(String bookingId) {
        this.bookingId = bookingId;
    }

}
