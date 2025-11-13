package io.emanuel.ms_user_api.domain.valueobjects;

import io.emanuel.ms_user_api.domain.aggretates.UserEmail;
import io.emanuel.ms_user_api.domain.aggretates.UserName;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class UserData {
     private UserName name;
     private UserEmail email;
     private Boolean active;
}
