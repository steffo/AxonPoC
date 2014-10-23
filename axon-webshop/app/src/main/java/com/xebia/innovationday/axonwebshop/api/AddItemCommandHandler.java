package com.xebia.innovationday.axonwebshop.api;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddItemCommandHandler {
    private final static Logger logger = LoggerFactory.getLogger(AddItemCommandHandler.class);

    private Repository<Cart> repository;

    public void setRepository(Repository<Cart> repository) {
        this.repository = repository;
    }

    @CommandHandler
    public void handle(AddItemCommand command) {
        logger.warn("received CreateCart {}", command.getCartId());
        try {
            Cart cart = repository.load(command.getCartId());
            logger.warn("cart {} already exists", command.getCartId());
            cart.handle(command);
        } catch (Exception e) {
            Cart cart = new Cart(command);
            repository.add(cart);
            logger.warn("added cart {} to repository", command.getCartId());
        }
    }
}
