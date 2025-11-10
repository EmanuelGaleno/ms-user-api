package io.emanuel.ms_user_api.domain.entity;

import lombok.Getter;
import lombok.Builder;
import java.util.UUID;
import java.time.LocalDateTime;
import io.emanuel.ms_user_api.domain.valueobjects.UserData;
import io.emanuel.ms_user_api.domain.valueobjects.UserEmail;
import io.emanuel.ms_user_api.domain.valueobjects.UserName;
import io.emanuel.ms_user_api.domain.validators.UserValidator;

@Builder
@Getter
public class User {

    private UUID id;
    private UserName name;
    private UserEmail email;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private static final UserValidator validator = new UserValidator();

    public static User create(UserData data, LocalDateTime createdAt, LocalDateTime updatedAt) {
        User user = User.builder()
                .id(UUID.randomUUID())
                .name(data.getName())
                .email(data.getEmail())
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();

        return user;
    }

    public static User rebuild(UserData data, UUID id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        User user = User.builder()
                .id(id)
                .name(data.getName())
                .email(data.getEmail())
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
        return user;
    }
}
