package io.emanuel.ms_user_api.domain.valueobjects;

import java.util.regex.Pattern;
import io.emanuel.ms_user_api.common.exceptions.DomainException;

public record UserEmail(String email) {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public static UserEmail of(String value) {
        if (value == null || !EMAIL_PATTERN.matcher(value).matches()) {
            throw new DomainException("E-mail inválido");
        }
        return new UserEmail(value.toLowerCase());
    }
}
