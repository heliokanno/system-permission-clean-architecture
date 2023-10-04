package com.hmk.system.permission.web.response;

import com.hmk.system.permission.business.domain.User;
import com.hmk.system.permission.business.domain.enumeration.StatusEnum;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Builder
public class UserResponse {

    private Long id;

    private String name;

    private String email;

    private StatusEnum status;

    public static UserResponse from(final User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();
    }
}
