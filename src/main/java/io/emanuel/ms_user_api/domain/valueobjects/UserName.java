package io.emanuel.ms_user_api.domain.valueobjects;

public record UserName(String value) {

    public static UserName of(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Nome do usuário não pode ser vazio");
        }
        if (value.length() < 3) {
            throw new IllegalArgumentException("Nome do usuário deve ter pelo menos 3 caracteres");
        }
        return new UserName(value);
    }
}
