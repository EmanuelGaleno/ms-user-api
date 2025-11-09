package io.emanuel.ms_user_api.common.exceptions;

import java.util.List;

public class DomainException extends RuntimeException {

    private final List<String> errors;

    public DomainException(String message) {
        super(message);
        this.errors = List.of(message);
    }

    public DomainException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
