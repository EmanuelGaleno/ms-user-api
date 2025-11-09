package io.emanuel.ms_user_api.domain.valueobjects;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class UserData {
     private UserName name;
     private UserEmail email;

}
