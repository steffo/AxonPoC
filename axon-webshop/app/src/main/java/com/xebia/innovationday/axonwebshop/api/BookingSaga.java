package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.domain.GenericEventMessage;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.scheduling.EventScheduler;
import org.axonframework.eventhandling.scheduling.ScheduleToken;
import org.axonframework.saga.annotation.AbstractAnnotatedSaga;
import org.axonframework.saga.annotation.EndSaga;
import org.axonframework.saga.annotation.SagaEventHandler;
import org.axonframework.saga.annotation.StartSaga;
import org.joda.time.Duration;

public class BookingSaga extends AbstractAnnotatedSaga {

    private transient CommandGateway commandGateway;
    private transient EventBus eventBus;
    private transient EventScheduler eventScheduler;
    private ScheduleToken timeOutToken;

    @StartSaga
    @SagaEventHandler(associationProperty = "bookingId")
    public void handle(BookingRequestedEvent bookingRequestedEvent) {

        eventBus.publish(new GenericEventMessage<HurrayEvent>(new HurrayEvent()));

        timeOutToken = eventScheduler.schedule(Duration.millis(1000), new SeatReservationTimedOutEvent(bookingRequestedEvent.getBookingId()));
        commandGateway.send(new ReserveSeatCommand(bookingRequestedEvent.getFlightId(), bookingRequestedEvent.getBookingId()));
    }

    @SagaEventHandler(associationProperty = "bookingId")
    @EndSaga
    public void handle(SeatReservedEvent event) {
        eventScheduler.cancelSchedule(timeOutToken);
        commandGateway.send(new CompleteBookingCommand(event.getBookingId()));
    }

    public void setCommandGateway(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void setEventScheduler(EventScheduler eventScheduler) {
        this.eventScheduler = eventScheduler;
    }

    @SagaEventHandler(associationProperty = "bookingId")
    @EndSaga
    public void handle(SeatReservationTimedOutEvent event) {
        commandGateway.send(new CancelBookingCommand(event.getBookingId()));
    }
}
