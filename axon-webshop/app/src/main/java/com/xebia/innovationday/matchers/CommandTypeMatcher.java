package com.xebia.innovationday.matchers;

import org.axonframework.commandhandling.CommandMessage;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class CommandTypeMatcher extends BaseMatcher<CommandMessage> {

    private final Class<?> clazz;

    public CommandTypeMatcher(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean matches(Object other) {
        if (other instanceof CommandMessage) {
            CommandMessage<?> message = (CommandMessage<?>) other;
            return clazz.equals(message.getPayloadType());
        } else {
            return false;
        }
    }

    @Override
    public void describeTo(Description d) {
        d.appendText("match type " + clazz.getName());
    }

}
