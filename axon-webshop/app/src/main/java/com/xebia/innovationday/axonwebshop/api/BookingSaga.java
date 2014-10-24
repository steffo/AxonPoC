package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.saga.annotation.AbstractAnnotatedSaga;
import org.axonframework.saga.annotation.SagaEventHandler;
import org.axonframework.saga.annotation.StartSaga;

public class BookingSaga extends AbstractAnnotatedSaga {

    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "bookingId")
    public void handle(BookingRequestedEvent bookingRequestedEvent) {

        commandGateway.send(new ReserveSeatCommand(bookingRequestedEvent.getFlightId(), bookingRequestedEvent.getBookingId()));
    }

    public void setCommandGateway(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

}
