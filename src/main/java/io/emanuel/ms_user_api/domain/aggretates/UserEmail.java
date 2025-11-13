package io.emanuel.ms_user_api.domain.aggretates;

import io.emanuel.ms_user_api.common.exceptions.DomainException;
import java.util.regex.Pattern;

public record UserEmail(String value) {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public UserEmail {
        if (value == null || !EMAIL_PATTERN.matcher(value).matches()) {
            throw new DomainException("E-mail inválido.");
        }
    }

    public static UserEmail of(String value) {
        return new UserEmail(value.toLowerCase());
    }
}
