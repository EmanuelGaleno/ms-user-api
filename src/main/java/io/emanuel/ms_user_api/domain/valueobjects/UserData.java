package io.emanuel.ms_user_api.domain.valueobjects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserData {
     private UserName name;
     private UserEmail email;

}
