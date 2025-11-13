package io.emanuel.ms_user_api.domain.aggretates;

import io.emanuel.ms_user_api.common.exceptions.DomainException;

public record UserName(String value) {

    public UserName {
        if (value == null || value.isBlank()) {
            throw new DomainException("Nome do usuário não pode ser vazio.");
        }
        if (value.length() < 3) {
            throw new DomainException("Nome do usuário deve ter pelo menos 3 caracteres.");
        }
    }

    public static UserName of(String value) {
        return new UserName(value.trim());
    }
}
