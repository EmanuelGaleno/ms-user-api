package io.emanuel.ms_user_api.domain.entity;


import io.emanuel.ms_user_api.domain.valueobjects.UserEmail;
import io.emanuel.ms_user_api.domain.valueobjects.UserName;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

    private UserName name;
    private UserEmail email;
    private Boolean active;

}
