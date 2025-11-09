package io.emanuel.ms_user_api.domain.valueobjects;

import io.emanuel.ms_user_api.common.exceptions.DomainException;

import java.util.regex.Pattern;

public record UserEmail(String email) {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    public static UserEmail of(String value) {
        if (value == null || !EMAIL_PATTERN.matcher(value).matches()) {
            throw new DomainException("E-mail inválido");
        }
        return new UserEmail(value.toLowerCase());
    }
}
