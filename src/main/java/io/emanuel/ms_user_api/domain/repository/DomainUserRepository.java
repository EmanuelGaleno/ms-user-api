package io.emanuel.ms_user_api.domain.repository;

import java.util.UUID;
import java.util.Optional;
import io.emanuel.ms_user_api.domain.entity.User;
import io.emanuel.ms_user_api.domain.valueobjects.UserName;

public interface DomainUserRepository {

    User save(User user);

    Optional<User> findById(UUID id);

    Optional<User> findByName(UserName name);
}
