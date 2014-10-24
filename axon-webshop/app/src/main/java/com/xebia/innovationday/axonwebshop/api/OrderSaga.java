package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.saga.annotation.AbstractAnnotatedSaga;
import org.axonframework.saga.annotation.SagaEventHandler;
import org.axonframework.saga.annotation.StartSaga;

public class OrderSaga extends AbstractAnnotatedSaga {

    private transient CommandGateway commmandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent orderCreatedEvent) {
        commmandGateway.send(new ReserveSeatCommand());
    }

    public void setCommmandGateway(CommandGateway commmandGateway) {
        this.commmandGateway = commmandGateway;
    }

}
