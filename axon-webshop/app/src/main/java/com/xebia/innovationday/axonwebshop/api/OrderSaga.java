package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.saga.annotation.AbstractAnnotatedSaga;
import org.axonframework.saga.annotation.SagaEventHandler;
import org.axonframework.saga.annotation.StartSaga;

import java.util.UUID;

public class OrderSaga extends AbstractAnnotatedSaga {

    private transient CommandGateway commmandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent orderCreatedEvent) {

        commmandGateway.send(new ReserveSeatCommand(UUID.randomUUID().toString()));
    }

    public void setCommmandGateway(CommandGateway commmandGateway) {
        this.commmandGateway = commmandGateway;
    }

}
