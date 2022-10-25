package com.HospitalSystem.entity;

import java.util.Optional;

/**
 *
 * @author Hakim
 */
public class AuthErrorMessage implements Message {

    private Optional<String> message;

    public AuthErrorMessage(String message) {
        this.message = Optional.of(message);
    }

    public AuthErrorMessage() {
        this.message = Optional.ofNullable(null);
    }

    @Override
    public Optional<String> getMesssage() {
        return message;
    }

    @Override
    public void setMessage(String msg) {
        if (!message.isPresent()) {
            message = Optional.of(msg);
        }

        String ms = message.get();
        ms = ms.concat(msg);

        message = Optional.of(ms);

    }

    @Override
    public void clear() {
        message =Optional.ofNullable(null);
    }

}
