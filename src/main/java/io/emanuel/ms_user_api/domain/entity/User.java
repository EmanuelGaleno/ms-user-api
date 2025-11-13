package io.emanuel.ms_user_api.domain.entity;

import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.UUID;
import io.emanuel.ms_user_api.common.exceptions.DomainException;
import io.emanuel.ms_user_api.domain.validators.UserValidator;
import io.emanuel.ms_user_api.domain.valueobjects.UserData;
import io.emanuel.ms_user_api.domain.aggretates.UserEmail;
import io.emanuel.ms_user_api.domain.aggretates.UserName;

@Builder
@Getter
public class User {

    private final UUID id;
    private UserName name;
    private UserEmail email;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private static final UserValidator validator = new UserValidator();
    private static final String CLAZZ = User.class.getSimpleName();

    public static User create(UserData data) {
        User user = User.builder()
                .id(UUID.randomUUID())
                .name(data.getName())
                .email(data.getEmail())
                .active(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        selfValidate(user);
        return user;
    }

    public static User rebuild(UserData data, UUID id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        User user = User.builder()
                .id(id)
                .name(data.getName())
                .email(data.getEmail())
                .active(data.getActive())
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();

        selfValidate(user);
        return user;
    }

    public void activate() {
        if (Boolean.TRUE.equals(this.active)) {
            throw new DomainException("Usuário já está ativo.");
        }
        this.active = true;
        this.updatedAt = LocalDateTime.now();

        selfValidate(this);
    }

    public void deactivate() {
        if (Boolean.FALSE.equals(this.active)) {
            throw new DomainException("Usuário já está inativo.");
        }
        this.active = false;
        this.updatedAt = LocalDateTime.now();

        selfValidate(this);
    }

    public void update(String rawName, String rawEmail) {
        this.name = UserName.of(rawName);
        this.email = UserEmail.of(rawEmail);
        this.updatedAt = LocalDateTime.now();

        selfValidate(this);
    }

    private static void selfValidate(User user) {
        ValidationResult result = validator.validate(user);
        if (!result.isValid()) {
            throw new DomainException(
                    "Falha ao validar instância de " + CLAZZ,
                    result.getErrors().stream().map(Error::getMessage).toList()
            );
        }
    }
}
